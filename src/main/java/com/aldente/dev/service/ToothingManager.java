package com.aldente.dev.service;

import java.util.Optional;

import com.aldente.dev.model.Toothing;
import com.aldente.dev.repo.ToothingRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToothingManager {
    
    private final ToothingRepo toothingRepo;

    @Autowired
    public ToothingManager(ToothingRepo toothingRepo) {
        super();
        this.toothingRepo = toothingRepo;
    }

    public Optional<Toothing> findById(Long id) {
        return toothingRepo.findById(id);
    }

    public Iterable<Toothing> findAll() {
        return toothingRepo.findAll();
    }

    public Toothing save(Toothing toothing) {
        return toothingRepo.save(toothing);
    }

    public void deleteById(Long id) {
        toothingRepo.deleteById(id);
    }
    
}
