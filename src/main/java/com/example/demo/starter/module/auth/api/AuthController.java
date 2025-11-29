package com.example.demo.starter.module.auth.api;

import com.example.demo.starter.module.auth.application.dto.LoginDto;
import com.example.demo.starter.module.auth.application.dto.RegisterDto;
import com.example.demo.starter.module.auth.application.service.AuthService;
import com.example.demo.starter.shared.base.controller.BaseController;
import com.example.demo.starter.shared.util.response.AuthResponse;
import com.example.demo.starter.shared.util.response.ServiceResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController extends BaseController {
    private final AuthService authService;

    @PostMapping("/login")
    @Operation(summary = "Basic Login with username and password", description = "Basic Login with username and password")
    public ResponseEntity<ServiceResponse<AuthResponse>> login(@RequestBody LoginDto model) {
        return controllerResponse(authService.login(model));
    }

    @PostMapping("/refresh-token-login/{refreshToken}")
    @Operation(summary = "Basic Login With Refresh Token", description = "Basic Login With Refresh Token")
    public ResponseEntity<ServiceResponse<AuthResponse>> login(@PathVariable String refreshToken) throws BadRequestException {
        return controllerResponse(authService.loginWithRefreshToken(refreshToken));
    }

    @PostMapping("/register")
    @Operation(summary = "Basic Register", description = "Basic Register")
    public ResponseEntity<ServiceResponse<String>> register(@RequestBody RegisterDto model) throws BadRequestException {
        return controllerResponse(authService.register(model));
    }


}
