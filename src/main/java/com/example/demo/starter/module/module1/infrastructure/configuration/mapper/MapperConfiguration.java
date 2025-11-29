package com.example.demo.starter.module.module1.infrastructure.configuration.mapper;

import com.example.demo.starter.module.module1.application.dto.Module1Dto;
import com.example.demo.starter.module.module1.domain.entity.Module1Entity;
import com.example.demo.starter.shared.base.dto.BaseDto;
import com.example.demo.starter.shared.base.entity.BaseEntity;
import com.example.demo.starter.shared.base.configuration.mapper.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {

    @Bean
    public Mapper<BaseEntity, BaseDto> baseMapper() {
        return new Mapper<>(BaseEntity.class, BaseDto.class);
    }
    @Bean
    public Mapper<Module1Entity, Module1Dto> module1Mapper() {
        return new Mapper<>(Module1Entity.class, Module1Dto.class);
    }
}