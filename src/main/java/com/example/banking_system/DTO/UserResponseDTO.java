package com.example.banking_system.DTO;

public record UserResponseDTO(
    String id,
    String email,
    String password,
    Integer cpf,    
    String fullName, 
    Boolean active
) {}
