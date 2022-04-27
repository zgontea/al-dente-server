package com.aldente.dev.service;

import java.util.Optional;

import com.aldente.dev.model.Appointment;
import com.aldente.dev.repo.AppointmentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentManager {
    
    private final AppointmentRepo appointmentRepo;

    @Autowired
    public AppointmentManager(AppointmentRepo appointmentRepo) {
        super();
        this.appointmentRepo = appointmentRepo;
    }

    public Optional<Appointment> findById(Long id) {
        return appointmentRepo.findById(id);
    }

    public Iterable<Appointment> findAll() {
        return appointmentRepo.findAll();
    }

    public Appointment save(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    public void deleteById(Long id) {
        appointmentRepo.deleteById(id);
    }
    
}
