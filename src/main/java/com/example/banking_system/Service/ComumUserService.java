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
import com.example.banking_system.Mapper.ComumUserMapper;
import com.example.banking_system.Module.User;
import com.example.banking_system.Repository.UserRepository;

@Service
public class ComumUserService {
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    ComumUserMapper comumUserMapper;


    public UserResponseDTO create(UserRequestDTO userRequestDTO) {
        try {
            User user = comumUserMapper.toModel(userRequestDTO);
            user = userRepository.save(user);
            // Logger.info("[INFO] User "+user.Id+" criado com sucesso.");
            return comumUserMapper.toDTO(user);
        } catch (Exception e) {
            // Logger.error("[ERRO] O sistema não conseguiu criar user::\n\n" + e.getMessage());
            throw new SystemException().user();
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
                userResponseDTOs.add(comumUserMapper.toDTO(user));
            }

            // Logger.info("[INFO] Users selecionados:: \n\n" + List.of(comumUserMapper.toString(optionalUser.get())));
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

            // Logger.info("[INFO] User selecionado:: \n\n" + comumUserMapper.toString(optionalUser.get()));
            return comumUserMapper.toDTO(optionalUser.get());
        } catch (Exception e) {
            // Logger.error("[ERRO] O sistema não conseguiu selecionar user pelo CPF "+cpf+"::\n\n" + e.getMessage());
            throw new SystemException();
        }
    }
    
}
