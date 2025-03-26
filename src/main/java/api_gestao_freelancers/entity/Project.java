package api_gestao_freelancers.entity;

import api_gestao_freelancers.entity.enums.StatusProject;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private LocalDateTime deadline;

    private Double estimatedBudget;

    @Enumerated(EnumType.STRING)
    private StatusProject status;
}
