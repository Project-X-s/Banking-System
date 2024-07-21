package com.example.banking_system.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.banking_system.Module.User;
import com.example.banking_system.Module.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    @Query("SELECT w FROM Wallet w WHERE w.owner.cpf = :cpf")
    Optional<User> findByOwner(@Param("cpf") Integer cpf);
}
