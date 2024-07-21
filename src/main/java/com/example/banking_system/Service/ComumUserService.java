package com.example.banking_system.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banking_system.DTO.UserRequestDTO;
import com.example.banking_system.DTO.UserResponseDTO;
import com.example.banking_system.Exception.NotFoundException;
import com.example.banking_system.Exception.SystemException;
import com.example.banking_system.Mapper.UserMapper;
import com.example.banking_system.Module.User;
import com.example.banking_system.Repository.UserRepository;

@Service
public class ComumUserService {
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    UserMapper userMapper;


    public UserResponseDTO create(UserRequestDTO userRequestDTO) {
        try {
            User user = userMapper.toModel(userRequestDTO);
            user = userRepository.save(user);
            // Logger.info("[INFO] User "+user.Id+" criado com sucesso.");
            return userMapper.toDTO(user);
        } catch (Exception e) {
            // Logger.error("[ERRO] O sistema não conseguiu criar user::\n\n" + e.getMessage());
            throw new RuntimeException("Falha ao criar o usuário"+ e);
        }
    }
    
    public List<UserResponseDTO> select() {
        try {
            List<User> users = userRepository.findAll();
            if (users.isEmpty()) {
                // Logger.error("[ERROR] Nenhum user não encontrado!");
                throw new NotFoundException().toUser();
            }
            List<UserResponseDTO> userResponseDTOs = new ArrayList<>();
            for (User user : users) {
                userResponseDTOs.add(userMapper.toDTO(user));
            }

            // Logger.info("[INFO] Users selecionados:: \n\n" + List.of(userMapper.toString(optionalUser.get())));
            return userResponseDTOs;
        } catch (Exception e) {
            // Logger.error("[ERRO] O sistema não conseguiu selecionar os users::\n\n" + e.getMessage());
            throw new SystemException().user();
        }
    }

    public UserResponseDTO selectByCpf(Integer cpf) {
        try {
            Optional<User> optionalUser = userRepository.findByCPF(cpf);
            
            if (optionalUser.isEmpty()) {
                // Logger.error("[ERROR] User com o CPF 'd%' não encontrado!".formatted(cpf));
                throw new NotFoundException().toUser(cpf);
            }

            // Logger.info("[INFO] User selecionado:: \n\n" + userMapper.toString(optionalUser.get()));
            return userMapper.toDTO(optionalUser.get());
        } catch (Exception e) {
            // Logger.error("[ERRO] O sistema não conseguiu selecionar user pelo CPF "+cpf+"::\n\n" + e.getMessage());
            throw new SystemException();
        }
    }
    
}
