package com.example.demo.starter.module.auth.infrastructure.configuration.mapper;

import com.example.demo.starter.module.auth.application.dto.UserDto;
import com.example.demo.starter.module.auth.domain.entity.User;
import com.example.demo.starter.shared.base.configuration.mapper.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("authMapperConfiguration")
public class MapperConfiguration {
    @Bean
    public Mapper<User, UserDto> userMapper() { return new Mapper<>(User.class, UserDto.class); }
}
