package com.example.banking_system.DTO;

import java.math.BigDecimal;

import com.example.banking_system.Module.User;
import com.example.banking_system.Module.Wallet;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record WalletRequestDTO(

    @NotBlank
    User owner,    

    @NotNull
    BigDecimal balance
) {
    public Wallet toWallet() {
        Wallet wallet = new Wallet();
        wallet.setOwner(owner);
        wallet.setBalance(balance);
        return wallet;
    }
}
