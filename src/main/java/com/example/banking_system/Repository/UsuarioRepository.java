package com.example.banking_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.banking_system.Module.User;

@Repository
public interface UsuarioRepository extends JpaRepository<User, String> {}
