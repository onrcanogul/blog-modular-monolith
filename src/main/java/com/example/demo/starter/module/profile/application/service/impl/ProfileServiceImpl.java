package com.example.demo.starter.module.profile.application.service.impl;

import com.example.demo.starter.module.profile.application.dto.ProfileDto;
import com.example.demo.starter.module.profile.application.service.ProfileService;
import com.example.demo.starter.module.profile.domain.entity.Profile;
import com.example.demo.starter.module.profile.infrastructure.repository.ProfileRepository;
import com.example.demo.starter.shared.base.configuration.mapper.Mapper;
import com.example.demo.starter.shared.base.service.impl.BaseServiceImpl;
import com.example.demo.starter.shared.util.response.ServiceResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileServiceImpl extends BaseServiceImpl<Profile, ProfileDto> implements ProfileService {
    private final ProfileRepository repository;
    private final Mapper<Profile, ProfileDto> mapper;
    public ProfileServiceImpl(
            ProfileRepository repository,
            Mapper<Profile, ProfileDto> mapper
    ) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ServiceResponse<ProfileDto> getByUser(UUID userId) {
        Profile profile = repository.findByUserId(userId).orElseThrow();
        ProfileDto dto = mapper.toDto(profile);
        return ServiceResponse.success(dto, 200);
    }

    @Override
    public ServiceResponse<ProfileDto> create(UUID userId) {
        Profile profile = Profile.create(userId);
        Profile created = repository.save(profile);
        return ServiceResponse.success(mapper.toDto(created), 200);
    }

    @Override
    public ServiceResponse<ProfileDto> addPostCount(UUID userId) {
        Profile profile = repository.findByUserId(userId).orElseThrow();
        profile.addPost();
        Profile savedProfile = repository.save(profile);
        return ServiceResponse.success(mapper.toDto(savedProfile), 200);
    }
}
