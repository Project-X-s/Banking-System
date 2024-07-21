package com.example.banking_system.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.banking_system.DTO.AuthorizationDTO;

@FeignClient(
    name = "AuthorizationClient",
    url = "${client-authorization-service.url}"
)

public interface AuthorizationClient {
    
    @GetMapping
    ResponseEntity<AuthorizationDTO> isAuthorized();
}
