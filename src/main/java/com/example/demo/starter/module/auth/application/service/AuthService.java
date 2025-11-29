package com.example.demo.starter.module.auth.application.service;

import com.example.demo.starter.module.auth.application.dto.LoginDto;
import com.example.demo.starter.module.auth.application.dto.RegisterDto;
import com.example.demo.starter.shared.util.response.AuthResponse;
import com.example.demo.starter.shared.util.response.ServiceResponse;
import org.apache.coyote.BadRequestException;

public interface AuthService {
    ServiceResponse<AuthResponse> login(LoginDto request);
    ServiceResponse<AuthResponse> loginWithRefreshToken(String refreshToken) throws BadRequestException;
    ServiceResponse<String> register(RegisterDto request) throws BadRequestException;
}
