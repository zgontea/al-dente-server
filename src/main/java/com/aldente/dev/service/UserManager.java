package com.aldente.dev.service;

import java.util.Optional;

import com.aldente.dev.model.User;
import com.aldente.dev.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserManager {

    private final UserRepo userRepo;
	private final static String salt = BCrypt.gensalt();

    @Autowired
    public UserManager(UserRepo userRepo) {
        super();
        this.userRepo = userRepo;
    }

    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    public Iterable<User> findAll() {
        return userRepo.findAll();
    }

    public User save(User user) {
        return userRepo.save(user);
    }

    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    public Optional<User> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAtStart() {
        User user = new User();
        user.setEmail("janekgontarek@gmail.com");
        user.setName("Zbyszko");
        user.setSurname("TrzyCytryny");
        user.setPhone("793130773");
        user.setPassword(BCrypt.hashpw("123", salt));

        userRepo.save(user);
    }
}
