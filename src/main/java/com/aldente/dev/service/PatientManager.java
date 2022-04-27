package com.aldente.dev.service;

import java.util.Optional;

import com.aldente.dev.model.Patient;
import com.aldente.dev.repo.PatientRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientManager {

    private final PatientRepo patientRepo;

    @Autowired
    public PatientManager(PatientRepo patientRepo) {
        super();
        this.patientRepo = patientRepo;
    }

    public Optional<Patient> findById(Long id) {
        return patientRepo.findById(id);
    }

    public Iterable<Patient> findAll() {
        return patientRepo.findAll();
    }

    public Patient save(Patient patient) {
        return patientRepo.save(patient);
    }

    public void deleteById(Long id) {
        patientRepo.deleteById(id);
    }
    
}
