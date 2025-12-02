package com.example.demo.starter.shared.base.configuration.mapper;


import com.example.demo.starter.shared.base.dto.BaseDto;
import com.example.demo.starter.shared.base.entity.BaseEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("baseMapperConfiguration")
public class MapperConfiguration {
    @Bean
    public Mapper<BaseEntity, BaseDto> baseMapper() {
        return new Mapper<>(BaseEntity.class, BaseDto.class);
    }
}
