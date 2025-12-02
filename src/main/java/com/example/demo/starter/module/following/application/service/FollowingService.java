package com.example.demo.starter.module.following.application.service;

import com.example.demo.starter.module.following.application.dto.FollowDto;
import com.example.demo.starter.module.following.domain.entity.Follow;
import com.example.demo.starter.shared.base.service.BaseService;
import com.example.demo.starter.shared.util.response.ServiceResponse;

import java.util.UUID;

public interface FollowingService extends BaseService<Follow, FollowDto> {
    ServiceResponse<FollowDto> accept(UUID followerId, UUID followingId);
    ServiceResponse<FollowDto> reject(UUID followerId, UUID followingId);
}
