package com.example.demo.starter.module.article.infrastructure.configuration.mapper;

import com.example.demo.starter.module.article.application.dto.ArticleDto;
import com.example.demo.starter.module.article.domain.entity.Article;
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
    public Mapper<Article, ArticleDto> userMapper() { return new Mapper<>(Article.class, ArticleDto.class); }
}
