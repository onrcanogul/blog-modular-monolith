package com.example.demo.starter.module.following.application.dto;

import com.example.demo.starter.module.following.domain.enumeration.FollowingState;
import com.example.demo.starter.shared.base.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class FollowDto extends BaseDto {
    private UUID followerId;
    private UUID followingId;
    private FollowingState state = FollowingState.PENDING;
}
