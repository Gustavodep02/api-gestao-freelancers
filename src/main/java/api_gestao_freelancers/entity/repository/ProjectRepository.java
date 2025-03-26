package api_gestao_freelancers.entity.repository;

import api_gestao_freelancers.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
