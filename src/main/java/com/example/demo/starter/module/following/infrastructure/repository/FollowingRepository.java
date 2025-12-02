package com.example.demo.starter.module.following.infrastructure.repository;

import com.example.demo.starter.module.following.domain.entity.Follow;
import com.example.demo.starter.module.following.domain.enumeration.FollowingState;
import com.example.demo.starter.shared.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface FollowingRepository extends BaseRepository<Follow> {
    Optional<Follow> findByFollowerIdAndFollowingIdAndState(UUID followerId, UUID followingId, FollowingState state);
}
