package com.example.banking_system.DTO;

public record UserResponseDTO(
    String id,
    String email,
    String password,
    String fullName, 
    Integer cpf,    
    Boolean active
) {}
