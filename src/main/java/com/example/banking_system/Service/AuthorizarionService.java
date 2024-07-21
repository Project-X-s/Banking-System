package com.example.banking_system.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.banking_system.Client.AuthorizationClient;
import com.example.banking_system.DTO.AuthorizationDTO;
import com.example.banking_system.DTO.TransitionRequestDTO;
import com.example.banking_system.Exception.SystemException;

@Service
public class AuthorizarionService {
    
    @Autowired
    AuthorizationClient authorizationClient;

    public Boolean isAuthorized(TransitionRequestDTO transitionRequestDTO) {
        ResponseEntity<AuthorizationDTO> responseEntity = authorizationClient.isAuthorized();

        if (responseEntity.getStatusCode().isError()) {
            throw new SystemException().error("Erro na autorização");
        }

        return responseEntity.getStatusCode().is2xxSuccessful();
    }
}
