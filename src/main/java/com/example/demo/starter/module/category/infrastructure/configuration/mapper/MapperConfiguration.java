package com.example.demo.starter.module.category.infrastructure.configuration.mapper;

import com.example.demo.starter.module.category.application.dto.CategoryDto;
import com.example.demo.starter.module.category.domain.entity.Category;
import com.example.demo.starter.shared.base.configuration.mapper.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("categoryMapperConfiguration")
public class MapperConfiguration {
    @Bean
    public Mapper<Category, CategoryDto> categoryMapper() { return new Mapper<>(Category.class, CategoryDto.class); }
}
