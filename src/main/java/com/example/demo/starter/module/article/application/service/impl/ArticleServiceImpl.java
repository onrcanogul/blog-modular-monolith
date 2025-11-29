package com.example.demo.starter.module.article.application.service.impl;

import com.example.demo.starter.module.article.application.dto.ArticleDto;
import com.example.demo.starter.module.article.application.service.ArticleService;
import com.example.demo.starter.module.article.domain.entity.Article;
import com.example.demo.starter.module.article.infrastructure.repository.ArticleRepository;
import com.example.demo.starter.shared.base.configuration.mapper.Mapper;
import com.example.demo.starter.shared.base.repository.BaseRepository;
import com.example.demo.starter.shared.base.service.impl.BaseServiceImpl;
import com.example.demo.starter.shared.kernel.event.domain.DomainEventPublisher;
import com.example.demo.starter.shared.util.response.ServiceResponse;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article, ArticleDto> implements ArticleService {
    private final ArticleRepository repository;
    private final DomainEventPublisher eventPublisher;
    private final Mapper<Article, ArticleDto> mapper;
    public ArticleServiceImpl(ArticleRepository repository, Mapper<Article, ArticleDto> mapper, DomainEventPublisher eventPublisher) {
        super(repository, mapper);
        this.repository = repository;
        this.eventPublisher = eventPublisher;
        this.mapper = mapper;
    }


    @Override
    public ServiceResponse<ArticleDto> create(ArticleDto dto) {
        Article article = Article.create(dto.getContent(), dto.getTitle(), dto.getSummary());

        Article created = repository.save(article);

        eventPublisher.publishAll(article.pullEvents());

        return ServiceResponse.success(mapper.toDto(created), 200);
    }

    @Override
    protected void updateEntity(ArticleDto dto, Article entity) {
        entity = mapper.toEntity(dto);
    }
}
