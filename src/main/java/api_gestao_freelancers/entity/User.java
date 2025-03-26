package api_gestao_freelancers.entity;


import api_gestao_freelancers.entity.enums.MainProfile;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(name = "cpf_cnpj")
    private String cpfCnpj;

    @Column(unique = true)
    private String email;

    private String password;

    private boolean isClient = false;

    private boolean isFreelancer = false;

    @Enumerated(EnumType.STRING)
    private MainProfile mainProfile;

}
