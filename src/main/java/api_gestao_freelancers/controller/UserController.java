package api_gestao_freelancers.controller;

import api_gestao_freelancers.dto.UserDto;
import api_gestao_freelancers.entity.User;
import api_gestao_freelancers.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/users", produces = {"application/json"})
@Tag(name = "User", description = "API for User CRUD operations ")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User saveUser(@RequestBody @Valid UserDto userDto) {
        return userService.saveUser(userDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable(value = "id") Long id) {
        var user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}")
    public User updateUser(@PathVariable(value = "id") Long id, @RequestBody @Valid UserDto userDto) {
        return userService.updateUser(id, userDto);
    }
    @PutMapping("/{id}")
    public User replaceUser(@PathVariable(value = "id") Long id, @RequestBody @Valid UserDto userDto) {
        return userService.replaceUser(id, userDto);
    }
}
