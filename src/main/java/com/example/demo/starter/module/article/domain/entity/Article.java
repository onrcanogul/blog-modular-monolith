package com.example.demo.starter.module.article.domain.entity;

import com.example.demo.starter.module.article.domain.event.ArticleCreatedEvent;
import com.example.demo.starter.shared.kernel.domain.AggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(name = "articles")
public class Article extends AggregateRoot {
    private String content;
    private String title;
    private String summary;
    private UUID userId;

    public static Article create(String content, String title, String summary, UUID userId) {
        Article article = new Article();
        UUID id = UUID.randomUUID();
        article.setId(id);
        article.setContent(content);
        article.setTitle(title);
        article.setUserId(userId);
        article.setSummary(summary);
        article.registerEvent(new ArticleCreatedEvent(userId));
        return article;
    }
}
