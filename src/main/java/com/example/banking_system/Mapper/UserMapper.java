package com.example.banking_system.Mapper;

import org.springframework.stereotype.Component;

import com.example.banking_system.DTO.UserRequestDTO;
import com.example.banking_system.DTO.UserResponseDTO;
import com.example.banking_system.Module.User;

@Component
public abstract class UserMapper {
    
    public abstract User toModel(UserRequestDTO userRequestDTO);
    public abstract UserResponseDTO toDTO(User user);
}
