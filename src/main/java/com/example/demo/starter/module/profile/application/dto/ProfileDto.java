package com.example.demo.starter.module.profile.application.dto;

import com.example.demo.starter.shared.base.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ProfileDto extends BaseDto {
    private UUID userId;
    private int postCount;
    private int commentCount;
    private int rating;
    private int postViewCount;
    private int postLikeCount;
    private int profileViewCount;
}
