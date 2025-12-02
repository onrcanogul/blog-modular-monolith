package com.example.demo.starter.module.article.infrastructure.configuration.mapper;

import com.example.demo.starter.module.article.application.dto.ArticleDto;
import com.example.demo.starter.module.article.domain.entity.Article;
import com.example.demo.starter.shared.base.configuration.mapper.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {
    @Bean
    public Mapper<Article, ArticleDto> articleMapper() { return new Mapper<>(Article.class, ArticleDto.class); }
}
