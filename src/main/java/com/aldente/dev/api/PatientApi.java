package com.aldente.dev.api;

import java.util.Optional;

import com.aldente.dev.model.Patient;
import com.aldente.dev.service.PatientManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@CrossOrigin
@RequestMapping("/api/patients")
public class PatientApi {

    private PatientManager patientManager;

    @Autowired
    public PatientApi(PatientManager patientManager) {
        super();
        this.patientManager = patientManager;
    }

    @GetMapping("/all")
    public Iterable<Patient> getAll() {
        return patientManager.findAll();
    }

    @GetMapping("/id")
    public Optional<Patient> getById(@RequestParam Long index) {
        return patientManager.findById(index);
    }

    @GetMapping(value = "/{patientId}")
    public Optional<Patient> getId(@PathVariable("patientId") Long patientId) {
        return patientManager.findById(patientId);
    }

    // @PostMapping("/save")
    // public Patient add(@RequestBody PatientWrapper patientWrapper) {
    //     Patient patient = new Patient();
    //     patient.setAdmin(false);
    //     patient.setEmail(patientWrapper.email);
    //     patient.setName(patientWrapper.name);
    //     patient.setPhone(patientWrapper.phone);
    //     patient.setSurname(patientWrapper.surname);
    //     patient.setPassword(patientWrapper.password);
    //     return patientManager.save(patient);
    // }

    @PutMapping("/upd")
    public Patient update(@RequestBody Patient patient) {
        return patientManager.save(patient);
    }

    @DeleteMapping("/del")
    public void delete(@RequestParam Long index) {
        patientManager.deleteById(index);
    }
    
    @Data
    public static class PatientWrapper {
        private String name;
        private String surname;
        private String email;
        private String password;
        private String phone;
    }
}
