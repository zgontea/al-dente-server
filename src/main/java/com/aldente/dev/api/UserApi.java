package com.aldente.dev.api;

import java.util.Optional;

import com.aldente.dev.model.User;
import com.aldente.dev.service.UserManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserApi {
    
    private UserManager userManager;

    @Autowired
	public UserApi(UserManager userManager) {
		super();
		this.userManager = userManager;
	}

    @GetMapping("/all")
    public Iterable<User> getAll() {
        return userManager.findAll();
    }

    @GetMapping("/id")
    public Optional<User> getById(@RequestParam Long index) {
        return userManager.findById(index);
    }

    @GetMapping(value = "/{userId}")
    public Optional<User> getId(@PathVariable("userId") Long userId) {
        return userManager.findById(userId);
    }

    @PostMapping("/save")
    public User add(@RequestBody UserWrapper userWrapper) {
        User user = new User();
        user.setEmail(userWrapper.email);
        user.setName(userWrapper.name);
        user.setPhone(userWrapper.phone);
        user.setSurname(userWrapper.surname);
        user.setPassword(userWrapper.password);

        return userManager.save(user);
    }

    @PutMapping("/upd")
    public User update(@RequestBody User user) {
        return userManager.save(user);
    }

    @DeleteMapping("/del")
    public void delete(@RequestParam Long index) {
        userManager.deleteById(index);
    }

    @Data
    public static class UserWrapper {
        private String name;
        private String surname;
        private String email;
        private String password;
        private String phone;
    }
}
