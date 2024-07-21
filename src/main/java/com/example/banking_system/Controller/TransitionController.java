package com.example.banking_system.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.banking_system.DTO.TransitionRequestDTO;
import com.example.banking_system.Exception.SystemException;
import com.example.banking_system.Module.Transition;
import com.example.banking_system.Service.TransitionService;
import com.example.banking_system.Utils.Response;

import jakarta.validation.Valid;

@RestController
public class TransitionController {
    
    @Autowired
    TransitionService transitionService;

    @PostMapping("/transition")
    public ResponseEntity<Response<Transition>> transferencia(@RequestBody @Valid TransitionRequestDTO transitionRequestDTO) {
        try {
            Transition transition = transitionService.transferencia(transitionRequestDTO);
            return ResponseEntity.status(200).body(new Response<>(transition, null));
        } catch (SystemException e) {
            return ResponseEntity.status(200).body(new Response<>(null, e.getMensagem() + e.getMessage()));
        }
    }
}
