package com.aldente.dev.repo;

import com.aldente.dev.model.Toothing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToothingRepo extends JpaRepository<Toothing, Long> {
    
}
