package api_gestao_freelancers.entity;

import api_gestao_freelancers.enums.StatusProject;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;


@Entity
@Data
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
