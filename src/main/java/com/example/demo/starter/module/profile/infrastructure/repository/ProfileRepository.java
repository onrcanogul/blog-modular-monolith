package com.example.demo.starter.module.profile.infrastructure.repository;

import com.example.demo.starter.module.profile.domain.entity.Profile;
import com.example.demo.starter.shared.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfileRepository extends BaseRepository<Profile> {
    Optional<Profile> findByUserId(UUID userId);
}
