package com.example.banking_system.Module;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("COMUM")
public class ComumUser extends User {
    
}
