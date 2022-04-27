package com.aldente.dev.config;

import org.springframework.beans.factory.annotation.Value;

import java.security.SecureRandom;

public interface SecretHolder {
    @Value("${security.jwt.secret:secret}")
    String jwtSecret = new SecureRandom().toString();
}
