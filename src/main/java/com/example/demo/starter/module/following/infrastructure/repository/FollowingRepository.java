package com.example.demo.starter.module.following.infrastructure.repository;

import com.example.demo.starter.module.following.domain.entity.Follow;
import com.example.demo.starter.shared.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowingRepository extends BaseRepository<Follow> {
}
