package com.example.banking_system.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banking_system.DTO.WalletRequestDTO;
import com.example.banking_system.Exception.SystemException;
import com.example.banking_system.Mapper.WalletMapper;
import com.example.banking_system.Module.Wallet;
import com.example.banking_system.Repository.WalletRepository;

@Service
public class WalletService {
    
    @Autowired
    WalletRepository walletRepository;
    
    @Autowired
    WalletMapper walletMapper;
    
    public Wallet create(WalletRequestDTO DTO) {
        try {
            return walletRepository.save(DTO.toWallet());
        } catch (Exception e) {
            throw new SystemException();
        }
    }
}
