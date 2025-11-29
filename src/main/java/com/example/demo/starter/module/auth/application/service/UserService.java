package com.example.demo.starter.module.auth.application.service;

import com.example.demo.starter.module.auth.application.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.UUID;

public interface UserService extends UserDetailsService {
    UserDto getById(UUID userId);
    UUID getCurrentUserId();
}
