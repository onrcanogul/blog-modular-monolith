package com.example.demo.starter.module.article.infrastructure.repository;

import com.example.demo.starter.module.article.domain.entity.Article;
import com.example.demo.starter.shared.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends BaseRepository<Article> {
}
