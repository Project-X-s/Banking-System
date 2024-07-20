package com.example.banking_system.Controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.banking_system.DTO.UserRequestDTO;
import com.example.banking_system.DTO.UserResponseDTO;
import com.example.banking_system.Exception.NotFoundException;
import com.example.banking_system.Exception.SystemException;
import com.example.banking_system.Module.User;
import com.example.banking_system.Service.ComumUserService;
import com.example.banking_system.Utils.Response;

import jakarta.validation.Valid;

@RestController
public class ComumUserController {

    @Autowired
    ComumUserService comumUserService;
    
    @PostMapping("/create/user")
    public ResponseEntity<Response<UserResponseDTO>> criar(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        try {
            UserResponseDTO userResponseDTO = comumUserService.create(userRequestDTO);
            return ResponseEntity.status(201).body(new Response<>(userResponseDTO, null));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(new Response<>(null, e.getMessage() + e.getCause()));
        }
    }

    @GetMapping("/select/users")
    public ResponseEntity<Response<List<UserResponseDTO>>> listarTodos() {
        try {
            List<UserResponseDTO> userResponseDTOs = comumUserService.select();

            return ResponseEntity.status(200).body(new Response<>(userResponseDTOs, null));
        } catch(NotFoundException e) {
            return ResponseEntity.status(404).body(new Response<>(null, e.getMensagem()));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(new Response<>(null,"Erro ao listar todos usuários!"+ e.getMessage()));
        }
    }

    // @GetMapping("/listar/usuario/{id}")
    // public ResponseEntity<Object> listar(@PathVariable(value = "id") String id) {
    //     ResponseEntity<Object> response;
    //     try {
    //         Optional<User> optionaUsuario = usuarioRepository.findById(id);
    //         if (optionaUsuario.isEmpty()) {
    //             throw new NotFoundException().toUsuario(id);
    //         }
    //         User usuario = optionaUsuario.get();
    //         methodsOn(usuario);
    //         response = ResponseEntity.status(200).body(UserMapper.toSelectedDTO(usuario));
    //         // Logger.select("Usuário "+usuario.getId()+" selecionado com sucesso.");
    //     } catch (NotFoundException e) {
    //         response = ResponseEntity.status(404).body(e.getMensagem());
    //         // Logger.notFound("Usuário "+usuario.getId()+" não encontrado no sistema!");
    //     } catch (Exception e) {
    //         response = ResponseEntity.status(400).body("Erro ao selecionar o usuário com o id:: "+id);
    //         // Logger.error("Erro ao selecionar o usuário com o id:: "+id+" no sistema!\n\n"+ e.getMessage());
    //     }
    //     return response;
    // }

    @GetMapping("/select/user/")
    public ResponseEntity<Response<UserResponseDTO>> listarPorCPF(@RequestParam("CPF") Integer cpf) {
        try {
            UserResponseDTO userResponseDTO = comumUserService.selectByCpf(cpf);
            return ResponseEntity.status(200).body(new Response<>(userResponseDTO, null));
        } catch (NotFoundException e) {
            return ResponseEntity.status(404).body(new Response<>(null, e.getMensagem()));
        } catch (SystemException e) {
            return ResponseEntity.status(400).body(new Response<>(null, "Erro ao listar user com o CPF!" + e.getMessage()));
        }
    }

    // @PutMapping("/status/usuario/{id}")
    // public ResponseEntity<Object> modificarStatus(@PathVariable(value = "id") String id) {
    //     ResponseEntity<Object> response;
    //     try {
    //         Optional<User> optionalUsuario = usuarioRepository.findById(id);
    //         if (optionalUsuario.isEmpty()) {
    //             throw new NotFoundException().toUsuario(id);
    //         }
    //         User usuario = optionalUsuario.get();
    //         if (usuario.getAtivo()) {
    //             usuario.setAtivo(false);
    //         } else {
    //             usuario.setAtivo(true);
    //         }
    //         usuarioRepository.save(usuario);
    //         response = ResponseEntity.status(200).body("Status do usuário modificado com sucesso:: "+ usuario.getAtivo());  
    //     } catch (NotFoundException e) {
    //         response = ResponseEntity.status(404).body(e.getMensagem());
    //         // Logger.notFound("Usuário "+usuario.getId()+" não encontrado no sistema!");
    //     } catch (Exception e) {
    //         response = ResponseEntity.status(400).body("Erro ao modificar o status de atividade do usuário com o id:: "+id);
    //         // Logger.error("Erro ao modificar o status de atividade do usuário com o id:: "+id+" no sistema!\n\n"+ e.getMessage());
    //     }
    //     return response;
    // }

    // @DeleteMapping("/deletar/usuario/{id}")
    // public ResponseEntity<Object> deletar(@PathVariable(value = "id") String id) {
    //     ResponseEntity<Object> response;
    //     try {
    //         Optional<User> optionalUsuario = usuarioRepository.findById(id);
    //         if (optionalUsuario.isEmpty()) {
    //             throw new NotFoundException().toUsuario(id);
    //         }
    //         usuarioRepository.deleteById(id);
    //         response = ResponseEntity.status(200).body("Usuário com o id:: "+id+" deletado com sucesso.");
    //     } catch (NotFoundException e)  {
    //         response = ResponseEntity.status(404).body(e.getMensagem());
    //         // Logger.notFound("Usuário "+usuario.getId()+" não encontrado no sistema!");
    //     } catch (Exception e ) {
    //         response = ResponseEntity.status(400).body("Erro ao deletar usuário com o id:: "+id);
    //         // Logger.error("Erro ao deletar o usuário com o id:: "+id+" no sistema!\n\n"+ e.getMessage());
    //     }
    //     return response;
    // }


    private void methodsOn(User user) {
        user.add(linkTo(methodOn(ComumUserController.class).criar(null)).withRel("cadastrar"));
        // user.add(linkTo(methodOn(ComumUserController.class).deletar(user.getId())).withRel("deletar"));
        user.add(linkTo(methodOn(ComumUserController.class).listarTodos()).withRel("listarTodos"));
        user.add(linkTo(methodOn(ComumUserController.class).listarPorCPF(user.getCpf())).withRel("listarPorCpf"));
        // user.add(linkTo(methodOn(ComumUserController.class).modificar(user.getId(), null)).withRel("modificar"));
        // user.add(linkTo(methodOn(ComumUserController.class).modificarStatus(user.getId())).withRel("ativar"));
    }
}
