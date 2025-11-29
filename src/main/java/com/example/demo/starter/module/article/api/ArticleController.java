package com.example.demo.starter.module.article.api;

import com.example.demo.starter.module.article.application.dto.ArticleDto;
import com.example.demo.starter.module.article.application.service.ArticleService;
import com.example.demo.starter.shared.base.controller.BaseController;
import com.example.demo.starter.shared.util.response.ServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/article")
@RequiredArgsConstructor
public class ArticleController extends BaseController {
    private final ArticleService service;

    @PostMapping
    public ResponseEntity<ServiceResponse<ArticleDto>> create(@RequestBody ArticleDto dto) {
        return controllerResponse(service.create(dto));
    }
}
