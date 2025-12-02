package com.example.demo.starter.module.article.domain.event;

import com.example.demo.starter.shared.kernel.event.domain.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ArticleCreatedEvent implements DomainEvent {
    private UUID userId;
}
