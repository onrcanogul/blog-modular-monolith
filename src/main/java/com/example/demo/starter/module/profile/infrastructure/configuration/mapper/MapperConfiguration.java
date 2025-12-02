package com.example.demo.starter.module.profile.infrastructure.configuration.mapper;

import com.example.demo.starter.module.profile.application.dto.ProfileDto;
import com.example.demo.starter.module.profile.domain.entity.Profile;
import com.example.demo.starter.shared.base.configuration.mapper.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("profileMapperConfiguration")
public class MapperConfiguration {
    @Bean
    public Mapper<Profile, ProfileDto> profileMapper() {
        return new Mapper<>(Profile.class, ProfileDto.class);
    }
}
