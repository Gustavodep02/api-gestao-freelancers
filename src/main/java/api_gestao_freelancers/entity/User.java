package api_gestao_freelancers.entity;


import api_gestao_freelancers.enums.MainProfile;
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

    private boolean isClient = false;

    private boolean isFreelancer = false;

    @Enumerated(EnumType.STRING)
    private MainProfile mainProfile;

}
