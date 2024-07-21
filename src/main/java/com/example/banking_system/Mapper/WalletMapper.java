package com.example.banking_system.Mapper;

import org.springframework.stereotype.Component;

import com.example.banking_system.DTO.WalletResponseDTO;
import com.example.banking_system.Module.Wallet;

@Component
public class WalletMapper {
    
    public WalletResponseDTO toDTO(Wallet wallet) {
        WalletResponseDTO walletResponseDTO = new WalletResponseDTO(
            wallet.getId(), 
            wallet.getOwner(),
            wallet.getBalance()
        );
        return walletResponseDTO;
    }
}
