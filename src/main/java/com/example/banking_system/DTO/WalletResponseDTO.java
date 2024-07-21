package com.example.banking_system.DTO;

import java.math.BigDecimal;

import com.example.banking_system.Module.User;

public record WalletResponseDTO(
    Long id,
    User owner,
    BigDecimal balance
) {}
