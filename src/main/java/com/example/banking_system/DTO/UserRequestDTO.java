package com.example.banking_system.DTO;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UserRequestDTO(
    
    @NotBlank(message = "O email não pode estar em branco")  
    @Length(min = 10, max = 42, message = "O email deve ter entre 10 e 42 caracteres")
    String email,

    @NotBlank(message = "A senha não pode estar em branco")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d\\W]).{8,}$", message = "A senha não atende aos critérios mínimos de segurança")
    String password,
    
    @NotBlank(message = "O nome não pode estar em branco")
    @Length(max = 42, message = "O nome deve conter no maximo 42 caracteres")
    String fullName, 
    
    @NotNull
    Long cpf,
    
    @NotBlank(message = "O tipo não pode estar em branco")
    @Pattern(regexp = "COMUM|MERCHANT", message = "O tipo deve ser COMUM ou MERCHANT")
    String type
) {}
