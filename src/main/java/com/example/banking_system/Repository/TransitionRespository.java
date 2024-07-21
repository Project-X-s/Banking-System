package com.example.banking_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.banking_system.Module.Transition;

public interface TransitionRespository extends JpaRepository<Transition, Long> {
    
}
