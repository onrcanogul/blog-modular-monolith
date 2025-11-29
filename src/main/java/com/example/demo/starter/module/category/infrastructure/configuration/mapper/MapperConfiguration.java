package com.example.demo.starter.module.category.infrastructure.configuration.mapper;

import com.example.demo.starter.module.category.application.dto.CategoryDto;
import com.example.demo.starter.module.category.domain.entity.Category;
import com.example.demo.starter.shared.base.configuration.mapper.Mapper;
import com.example.demo.starter.shared.base.dto.BaseDto;
import com.example.demo.starter.shared.base.entity.BaseEntity;
import org.springframework.context.annotation.Bean;

public class MapperConfiguration {
    @Bean
    public Mapper<BaseEntity, BaseDto> baseMapper() {
        return new Mapper<>(BaseEntity.class, BaseDto.class);
    }
    @Bean
    public Mapper<Category, CategoryDto> categoryMapper() { return new Mapper<>(Category.class, CategoryDto.class); }
}
