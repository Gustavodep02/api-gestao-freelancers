package api_gestao_freelancers.service;

import api_gestao_freelancers.dto.UserDto;
import api_gestao_freelancers.entity.User;
import api_gestao_freelancers.exceptions.InvalidCPFCNPJException;
import api_gestao_freelancers.exceptions.ResourceNotFoundException;
import api_gestao_freelancers.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(UserDto userDto) {
        var user = new User();
        log.info("POST /user - creating user with the DTO received: {}", userDto);
        BeanUtils.copyProperties(userDto, user);
        validateCpfcnpj(user.getCpfCnpj());
        User savedUser = userRepository.save(user);
        log.debug("User saved with ID: {}", savedUser.getId());
        return savedUser;
    }

    public User getUser(Long id) {
        log.info("GET /user/{} - getting user", id);
        var userFound = userRepository.findById(id)
                .orElseThrow(() ->{
            log.error("User not found on getUser()");
            return new ResourceNotFoundException("User not found with id: " + id);
        });
        log.debug("User found: {}", userFound);
        return userFound;
    }

    public List<User> getAllUsers() {
        log.info("GET /user - getting all users");
        List<User> list = userRepository.findAll();
        log.debug("Users found: {}", list);
        return list;
    }

    public void deleteUser(Long id){
        log.info("DELETE /user/{} - deleting user", id);
        var user = userRepository.findById(id)
                .orElseThrow(() ->{
                    log.error("User not found on deleteUser()");
                    return new ResourceNotFoundException("User not found with id: " + id);
                });
        userRepository.delete(user);
        log.info("User {} deleted successfully", id);
    }

    public User replaceUser(Long id, UserDto userDto) {
        log.info("PUT /user/{} - replacing user with the DTO received: {}", id, userDto);

        var user = userRepository.findById(id);
        if (user.isEmpty()) {
            log.error("User not found on replaceUser()");
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        log.debug("User found on replaceUser(): {}", user);
        return userRepository.save(user.get());
    }

    public User updateUser(Long id, UserDto userDto) {
        log.info("PATCH /user/{} - updating user with the DTO received: {}", id, userDto);
        var patchUser = new User();
        BeanUtils.copyProperties(userDto, patchUser);
        return userRepository.findById(id)
                .map(user -> {
                    if (patchUser.getCpfCnpj() != null) {
                        user.setCpfCnpj(patchUser.getCpfCnpj());
                        validateCpfcnpj(user.getCpfCnpj());
                    }
                    if (patchUser.getEmail() != null) {
                        user.setEmail(patchUser.getEmail());
                    }
                    if (patchUser.getFullName() != null) {
                        user.setFullName(patchUser.getFullName());
                    }
                    if (patchUser.getPassword() != null) {
                        user.setPassword(patchUser.getPassword());
                    }
                    if (patchUser.getMainProfile() != null) {
                        user.setMainProfile(patchUser.getMainProfile());
                    }
                    User savedUser = userRepository.save(user);
                    log.debug("User updated with ID: {}", savedUser.getId());
                    return savedUser;
                })
                .orElseGet(() -> {
                    log.debug("User not found on updateUser()");
                    throw new ResourceNotFoundException("User not found with id: " + id);
                });
    }

    public void validateCpfcnpj(String cpfCnpj) {
        String digits = cpfCnpj.replaceAll("\\D", "");
        if (!(digits.length() == 11 || digits.length() == 14)) {
            log.error("Invalid CPF CNPJ");
            throw new InvalidCPFCNPJException("Invalid CPF/CNPJ");
        }
    }
}
