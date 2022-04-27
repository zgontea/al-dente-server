package com.aldente.dev.api;

import java.util.Optional;

import com.aldente.dev.model.Toothing;
import com.aldente.dev.service.ToothingManager;

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
@RequestMapping("/api/toothings")
public class ToothingApi {

    private ToothingManager toothingManager;

    @Autowired
    public ToothingApi(ToothingManager toothingManager) {
        super();
        this.toothingManager = toothingManager;
    }

    @GetMapping("/all")
    public Iterable<Toothing> getAll() {
        return toothingManager.findAll();
    }

    @GetMapping("/id")
    public Optional<Toothing> getById(@RequestParam Long index) {
        return toothingManager.findById(index);
    }

    @GetMapping(value = "/{ToothingId}")
    public Optional<Toothing> getId(@PathVariable("ToothingId") Long ToothingId) {
        return toothingManager.findById(ToothingId);
    }

    // @PostMapping("/save")
    // public Toothing add(@RequestBody ToothingWrapper ToothingWrapper) {
    //     Toothing Toothing = new Toothing();
    //     Toothing.setAdmin(false);
    //     Toothing.setEmail(ToothingWrapper.email);
    //     Toothing.setName(ToothingWrapper.name);
    //     Toothing.setPhone(ToothingWrapper.phone);
    //     Toothing.setSurname(ToothingWrapper.surname);
    //     Toothing.setPassword(ToothingWrapper.password);
    //     return ToothingManager.save(Toothing);
    // }

    @PutMapping("/upd")
    public Toothing update(@RequestBody Toothing toothing) {
        return toothingManager.save(toothing);
    }

    @DeleteMapping("/del")
    public void delete(@RequestParam Long index) {
        toothingManager.deleteById(index);
    }
    
    @Data
    public static class ToothingWrapper {
        private String name;
        private String surname;
        private String email;
        private String password;
        private String phone;
    }
}
