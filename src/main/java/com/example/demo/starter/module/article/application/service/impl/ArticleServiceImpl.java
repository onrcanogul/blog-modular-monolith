package com.example.demo.starter.module.article.application.service.impl;

import com.example.demo.starter.module.article.application.dto.ArticleDto;
import com.example.demo.starter.module.article.application.service.ArticleService;
import com.example.demo.starter.module.article.domain.entity.Article;
import com.example.demo.starter.module.article.infrastructure.repository.ArticleRepository;
import com.example.demo.starter.module.auth.application.service.UserService;
import com.example.demo.starter.shared.base.configuration.mapper.Mapper;
import com.example.demo.starter.shared.base.service.impl.BaseServiceImpl;
import com.example.demo.starter.shared.kernel.event.domain.DomainEventPublisher;
import com.example.demo.starter.shared.util.response.ServiceResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article, ArticleDto> implements ArticleService {
    private final ArticleRepository repository;
    private final DomainEventPublisher eventPublisher;
    private final Mapper<Article, ArticleDto> mapper;
    private final UserService userService;
    public ArticleServiceImpl(ArticleRepository repository, Mapper<Article, ArticleDto> mapper, DomainEventPublisher eventPublisher, UserService userService) {
        super(repository, mapper);
        this.repository = repository;
        this.eventPublisher = eventPublisher;
        this.mapper = mapper;
        this.userService = userService;
    }

    @Override
    public ServiceResponse<ArticleDto> create(ArticleDto dto) {
        UUID userId = userService.getCurrentUserId();
        Article article = Article.create(dto.getContent(), dto.getTitle(), dto.getSummary(), userId);
        Article created = repository.save(article);
        eventPublisher.publishAll(article.pullEvents());
        return ServiceResponse.success(mapper.toDto(created), 200);
    }
}
