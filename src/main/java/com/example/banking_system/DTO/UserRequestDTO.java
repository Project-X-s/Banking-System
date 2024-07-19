package com.example.banking_system.DTO;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserRequestDTO(
    
    @NotBlank(message = "O email não pode estar em branco")  
    @Length(min = 8, message = "O email deve ter no mínimo 10 caracteres")
    String email,

    @NotBlank(message = "A senha não pode estar em branco")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[\\d\\W])$", message = "A senha deve conter letras, números e símbolos para atender aos critérios mínimos de segurança")
    @Length(min = 8, max = 20, message = "A senha deve estar entre 8 a 20 caracteres")
    String password,

    @NotBlank(message = "O nome não pode estar em branco")
    @Length(max = 42, message = "O nome deve conter no maximo 42 caracteres")
    String fullName, 

    @Length(min = 11, max = 11, message = "O CPF deve ter exatamente 11 números")
    Integer cpf
) {}
