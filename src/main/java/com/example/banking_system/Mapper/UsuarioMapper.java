package com.example.banking_system.Mapper;

import com.example.banking_system.DTO.UserRequestDTO;
import com.example.banking_system.DTO.UserResponseDTO;
import com.example.banking_system.Module.User;

public class UsuarioMapper {
    
    public static User toModel(UserRequestDTO usuarioRequestDTO) {
        User usuarioModel = new User();
        usuarioModel.setNome(usuarioRequestDTO.nome());
        usuarioModel.setEmail(usuarioRequestDTO.email());
        usuarioModel.setSenha(usuarioRequestDTO.senha());
        usuarioModel.setGenero(usuarioRequestDTO.genero());
        usuarioModel.setDtNascimento(usuarioRequestDTO.dtNascimento());
        usuarioModel.setPais(usuarioRequestDTO.pais());
        usuarioModel.setFoto(usuarioRequestDTO.foto());
        usuarioModel.setAtivo(usuarioRequestDTO.ativo());
        return usuarioModel;
    }
    
    public static UserResponseDTO toDTO(User usuarioModel) {
        UserResponseDTO usuarioDTO = new UserResponseDTO(
            usuarioModel.getId(),
            usuarioModel.getEmail(),
            usuarioModel.getSenha(),
            usuarioModel.getNome(),
            usuarioModel.getFoto(),
            usuarioModel.getPais(),
            usuarioModel.getDtNascimento(),
            usuarioModel.getGenero(),
            usuarioModel.getAtivo()
        );
        return usuarioDTO;
    }

    public static UsuarioSelectedDTO toSelectedDTO(User usuarioModel) {
        UsuarioSelectedDTO usuarioSelectedDTO = new UsuarioSelectedDTO(
            usuarioModel.getId(),
            usuarioModel.getEmail(),
            usuarioModel.getNome(),
            usuarioModel.getFoto(),
            usuarioModel.getPais(),
            usuarioModel.getDtNascimento(),
            usuarioModel.getGenero()
        );
        return usuarioSelectedDTO;
    }
}
