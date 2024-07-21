package com.example.banking_system.Mapper;

import org.springframework.stereotype.Component;

import com.example.banking_system.DTO.UserRequestDTO;
import com.example.banking_system.DTO.UserResponseDTO;
import com.example.banking_system.Module.User;

@Component
public class UserMapper {
    
    public User toModel(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setEmail(userRequestDTO.email());
        user.setPassword(userRequestDTO.password());
        user.setCpf(userRequestDTO.cpf());
        user.setFullName(userRequestDTO.fullName());
        user.setType(userRequestDTO.type());
        user.setActive(true);
        return user;
    }

    public UserResponseDTO toDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO(
            user.getId(),
            user.getEmail(),
            user.getPassword(),
            user.getCpf(),
            user.getFullName(),
            user.getType(),
            user.getActive()
        );
        return userResponseDTO;
    }
}
