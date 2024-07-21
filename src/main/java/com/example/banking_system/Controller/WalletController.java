package com.example.banking_system.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.banking_system.DTO.WalletRequestDTO;
import com.example.banking_system.Exception.SystemException;
import com.example.banking_system.Module.Wallet;
import com.example.banking_system.Service.WalletService;
import com.example.banking_system.Utils.Response;

import jakarta.validation.Valid;

@RestController
public class WalletController {

    @Autowired
    WalletService walletService;
    
    @PostMapping("/wallets")
    public ResponseEntity<Response<Wallet>> criar(@RequestBody @Valid WalletRequestDTO walletRequestDTO) {
        try {
            Wallet walletResponseDTO = walletService.create(walletRequestDTO);
            return ResponseEntity.status(201).body(new Response<>(walletResponseDTO, null));
        } catch (SystemException e) {
            return ResponseEntity.status(400).body(new Response<>(null, e.getMensagem() + e.getMessage()));
        }
    }

}
