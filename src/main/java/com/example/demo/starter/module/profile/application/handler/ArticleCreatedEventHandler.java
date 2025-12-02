package com.example.demo.starter.module.profile.application.handler;

import com.example.demo.starter.module.article.domain.event.ArticleCreatedEvent;
import com.example.demo.starter.module.profile.application.service.ProfileService;
import com.example.demo.starter.shared.kernel.event.domain.DomainEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticleCreatedEventHandler implements DomainEventHandler<ArticleCreatedEvent> {
    private final ProfileService service;
    @Override
    public void handle(ArticleCreatedEvent event) {
        service.addPostCount(event.getUserId());
    }
}
