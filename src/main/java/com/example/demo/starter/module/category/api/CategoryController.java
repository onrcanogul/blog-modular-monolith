package com.example.demo.starter.module.category.api;

import com.example.demo.starter.module.category.application.dto.CategoryDto;
import com.example.demo.starter.module.category.application.service.CategoryService;
import com.example.demo.starter.shared.base.controller.BaseController;
import com.example.demo.starter.shared.util.response.ServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController extends BaseController {
    private final CategoryService service;

    @GetMapping
    public ResponseEntity<ServiceResponse<List<CategoryDto>>> get() {
        return controllerResponse(service.get(0, 50));
    }
}
