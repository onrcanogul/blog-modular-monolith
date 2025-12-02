package com.example.demo.starter.module.profile.api;

import com.example.demo.starter.module.profile.application.dto.ProfileDto;
import com.example.demo.starter.module.profile.application.service.ProfileService;
import com.example.demo.starter.shared.base.controller.BaseController;
import com.example.demo.starter.shared.util.response.ServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController extends BaseController {
    private final ProfileService service;

    @GetMapping("user/{userId}")
    public ResponseEntity<ServiceResponse<ProfileDto>> getByUser(@PathVariable UUID userId) {
        return controllerResponse(service.getByUser(userId));
    }
}
