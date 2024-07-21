package com.example.banking_system.DTO;

public record UserResponseDTO(
    String id,
    String email,
    String password,
    Long cpf,    
    String fullName, 
    String type, 
    Boolean active
) {}
