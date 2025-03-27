package api_gestao_freelancers.entity;


import api_gestao_freelancers.enums.StatusProposal;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime estimatedDelivery;

    @Enumerated(EnumType.STRING)
    private StatusProposal status;

}
