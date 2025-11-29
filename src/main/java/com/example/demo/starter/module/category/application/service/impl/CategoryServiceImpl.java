package com.example.demo.starter.module.category.application.service.impl;

import com.example.demo.starter.module.category.application.dto.CategoryDto;
import com.example.demo.starter.module.category.application.service.CategoryService;
import com.example.demo.starter.module.category.domain.entity.Category;
import com.example.demo.starter.module.category.infrastructure.repository.CategoryRepository;
import com.example.demo.starter.shared.base.configuration.mapper.Mapper;
import com.example.demo.starter.shared.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, CategoryDto> implements CategoryService {
    public CategoryServiceImpl(
            CategoryRepository repository,
            Mapper<Category, CategoryDto> mapper
    ) {
        super(repository, mapper);
    }


}
