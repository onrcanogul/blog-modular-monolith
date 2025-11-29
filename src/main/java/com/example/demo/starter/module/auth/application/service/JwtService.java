package com.example.demo.starter.module.auth.application.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.UUID;

public interface JwtService {
    String generateToken(UserDetails userDetails);
    String extractUsername(String token);
    UUID extractId(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    List<String> extractRoles(String token);
}
