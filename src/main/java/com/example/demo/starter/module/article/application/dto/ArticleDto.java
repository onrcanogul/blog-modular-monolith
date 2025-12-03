package com.example.demo.starter.module.article.application.dto;

import com.example.demo.starter.shared.base.dto.BaseDto;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ArticleDto extends BaseDto {
    private String content;
    private String title;
    private String summary;
    private UUID userId;
    private List<UUID> categoryIds;
}
