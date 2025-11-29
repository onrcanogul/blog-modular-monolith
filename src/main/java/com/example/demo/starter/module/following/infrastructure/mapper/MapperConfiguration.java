package com.example.demo.starter.module.following.infrastructure.mapper;

import com.example.demo.starter.module.following.application.dto.FollowDto;
import com.example.demo.starter.module.following.domain.entity.Follow;
import com.example.demo.starter.shared.base.configuration.mapper.Mapper;
import com.example.demo.starter.shared.base.dto.BaseDto;
import com.example.demo.starter.shared.base.entity.BaseEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {

    @Bean
    public Mapper<BaseEntity, BaseDto> baseMapper() {
        return new Mapper<>(BaseEntity.class, BaseDto.class);
    }
    @Bean
    public Mapper<Follow, FollowDto> followMapper() { return new Mapper<>(Follow.class, FollowDto.class); }
}
