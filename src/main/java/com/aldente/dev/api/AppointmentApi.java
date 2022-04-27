package com.aldente.dev.api;

import java.util.Optional;

import com.aldente.dev.model.Appointment;
import com.aldente.dev.service.AppointmentManager;

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
@RequestMapping("/api/appointments")
public class AppointmentApi {

    private AppointmentManager appointmentManager;

    @Autowired
    public AppointmentApi(AppointmentManager appointmentManager) {
        super();
        this.appointmentManager = appointmentManager;
    }

    @GetMapping("/all")
    public Iterable<Appointment> getAll() {
        return appointmentManager.findAll();
    }

    @GetMapping("/id")
    public Optional<Appointment> getById(@RequestParam Long index) {
        return appointmentManager.findById(index);
    }

    @GetMapping(value = "/{appointmentId}")
    public Optional<Appointment> getId(@PathVariable("appointmentId") Long appointmentId) {
        return appointmentManager.findById(appointmentId);
    }

    // @PostMapping("/save")
    // public appointment add(@RequestBody AppointmentWrapper appointmentWrapper) {
    //     appointment appointment = new appointment();
    //     appointment.setAdmin(false);
    //     appointment.setEmail(appointmentWrapper.email);
    //     appointment.setName(appointmentWrapper.name);
    //     appointment.setPhone(appointmentWrapper.phone);
    //     appointment.setSurname(appointmentWrapper.surname);
    //     appointment.setPassword(appointmentWrapper.password);
    //     return appointmentManager.save(appointment);
    // }

    @PutMapping("/upd")
    public Appointment update(@RequestBody Appointment appointment) {
        return appointmentManager.save(appointment);
    }

    @DeleteMapping("/del")
    public void delete(@RequestParam Long index) {
        appointmentManager.deleteById(index);
    }
    
    @Data
    public static class AppointmentWrapper {
        private String name;
        private String surname;
        private String email;
        private String password;
        private String phone;
    }
}
