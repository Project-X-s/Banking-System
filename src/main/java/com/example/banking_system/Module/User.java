package com.example.banking_system.Module;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "bs_user")
public class User extends RepresentationModel<User> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;

    @NotBlank
    @Email
    @Size(max = 42)
    @Column(nullable = false, length = 42, unique = true)
    private String email;
    
    @NotBlank
    @Size(max = 20)
    @Column(nullable = false, length = 20)
    private String password;

    @NotBlank
    @Size(max = 42)
    @Column(nullable = false, length = 42)
    private String fullName;
    
    @NotNull
    @Column(nullable = false, length = 11, unique = true)
    private Long cpf;
    
    @NotBlank
    @Column(name = "type", nullable = false)
    private String type;

    @NotNull
    @Column(nullable = false)
    private Boolean active;   

}
