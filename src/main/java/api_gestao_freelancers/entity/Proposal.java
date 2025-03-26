package api_gestao_freelancers.entity;


import api_gestao_freelancers.entity.enums.StatusProposal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime estimatedDelivery;

    @Enumerated(EnumType.STRING)
    private StatusProposal status;

}
