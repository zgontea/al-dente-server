package com.aldente.dev.repo;

import java.util.Optional;

import com.aldente.dev.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
}
