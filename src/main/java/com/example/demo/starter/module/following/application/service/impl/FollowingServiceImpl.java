package com.example.demo.starter.module.following.application.service.impl;

import com.example.demo.starter.module.following.application.dto.FollowDto;
import com.example.demo.starter.module.following.application.service.FollowingService;
import com.example.demo.starter.module.following.domain.entity.Follow;
import com.example.demo.starter.module.following.domain.enumeration.FollowingState;
import com.example.demo.starter.module.following.infrastructure.repository.FollowingRepository;
import com.example.demo.starter.shared.base.configuration.mapper.Mapper;
import com.example.demo.starter.shared.base.service.impl.BaseServiceImpl;
import com.example.demo.starter.shared.util.response.ServiceResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FollowingServiceImpl extends BaseServiceImpl<Follow, FollowDto> implements FollowingService {
    private final FollowingRepository repository;
    private final Mapper<Follow, FollowDto> mapper;
    public FollowingServiceImpl(FollowingRepository repository, Mapper<Follow, FollowDto> mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ServiceResponse<FollowDto> create(FollowDto dto) {
        Follow follow = Follow.create(dto.getFollowerId(), dto.getFollowingId());
        Follow created = repository.save(follow);
        return ServiceResponse.success(mapper.toDto(created), 200);
    }

    @Override
    public ServiceResponse<FollowDto> accept(UUID followerId, UUID followingId) {
        Follow follow = repository.findByFollowerIdAndFollowingIdAndState(followerId, followingId, FollowingState.PENDING).orElseThrow();
        follow.accept();
        Follow savedFollow = repository.save(follow);
        return ServiceResponse.success(mapper.toDto(savedFollow), 200);
    }

    @Override
    public ServiceResponse<FollowDto> reject(UUID followerId, UUID followingId) {
        Follow follow = repository.findByFollowerIdAndFollowingIdAndState(followerId, followingId, FollowingState.PENDING).orElseThrow();
        follow.reject();
        Follow savedFollow = repository.save(follow);
        return ServiceResponse.success(mapper.toDto(savedFollow), 200);
    }
}
