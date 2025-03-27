package api_gestao_freelancers.entity;


import api_gestao_freelancers.enums.MainProfile;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @NotNull
    @Column(name = "cpf_cnpj", unique = true)
    private String cpfCnpj;

    @Column(unique = true)
    private String email;

    private String password;

    private boolean isClient = true;

    private boolean isFreelancer = false;

    @Enumerated(EnumType.STRING)
    private MainProfile mainProfile = MainProfile.CLIENT;

    @PrePersist
    @PreUpdate
    private void validateUserType() {
        if (!isClient && !isFreelancer) {
            throw new IllegalStateException("The user must be client or freelancer.");
        }
    }
}
