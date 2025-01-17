package com.example.banking_system.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.banking_system.Module.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u FROM User u WHERE u.cpf = :cpf")
    Optional<User> findByCPF(@Param("cpf") Integer cpf);

    @Query("SELECT u FROM User u WHERE TYPE(u) = :type")
    List<User> findUsersByType(@Param("type") String type);
}
