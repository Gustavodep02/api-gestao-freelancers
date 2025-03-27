package api_gestao_freelancers.repository;

import api_gestao_freelancers.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
