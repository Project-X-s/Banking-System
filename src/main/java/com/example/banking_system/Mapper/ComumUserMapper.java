package com.example.banking_system.Mapper;

import org.springframework.stereotype.Component;

import com.example.banking_system.DTO.UserRequestDTO;
import com.example.banking_system.DTO.UserResponseDTO;
import com.example.banking_system.Module.ComumUser;
import com.example.banking_system.Module.User;

@Component
public class ComumUserMapper extends UserMapper {

    @Override
    public User toModel(UserRequestDTO userRequestDTO) {
        User user = new ComumUser();
        user.setEmail(userRequestDTO.email());
        user.setPassword(userRequestDTO.password());
        user.setCpf(userRequestDTO.cpf());
        user.setFullName(userRequestDTO.fullName());
        user.setActive(true);
        return user;
    }

    @Override
    public UserResponseDTO toDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO(
            user.getId(),
            user.getEmail(),
            user.getPassword(),
            user.getCpf(),
            user.getFullName(),
            user.getActive()
        );
        return userResponseDTO;
    }
    
}
