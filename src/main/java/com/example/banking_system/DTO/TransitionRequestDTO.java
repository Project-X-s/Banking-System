package com.example.banking_system.DTO;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public record TransitionRequestDTO(
    
    @NotNull
    Long wPayer,
    
    @NotNull
    Long wReceiver,

    @NotNull
    @DecimalMin("0.01")
    BigDecimal value
) {}
