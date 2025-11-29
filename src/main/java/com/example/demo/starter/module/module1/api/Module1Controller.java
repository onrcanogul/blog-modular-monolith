package com.example.demo.starter.module.module1.api;

import com.example.demo.starter.module.module1.application.dto.Module1Dto;
import com.example.demo.starter.module.module1.application.service.Module1Service;
import com.example.demo.starter.shared.base.controller.BaseController;
import com.example.demo.starter.shared.util.response.NoContent;
import com.example.demo.starter.shared.util.response.ServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/module1")
@RequiredArgsConstructor
public class Module1Controller extends BaseController {
    private final Module1Service service;

    @GetMapping
    public ResponseEntity<ServiceResponse<List<Module1Dto>>> get() {
        return controllerResponse(service.get(0, 50));
    }

    @PostMapping
    public ResponseEntity<ServiceResponse<Module1Dto>> create(Module1Dto dto) {
        return controllerResponse(service.create(dto));
    }

    @PutMapping
    public ResponseEntity<ServiceResponse<Module1Dto>> delete(Module1Dto dto) {
        return controllerResponse(service.update(dto, dto.getId()));
    }

    @DeleteMapping
    public ResponseEntity<ServiceResponse<NoContent>> get(@RequestParam UUID id) {
        return controllerResponse(service.delete(id));
    }
}
