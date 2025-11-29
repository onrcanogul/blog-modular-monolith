package com.example.demo.starter.module.profile.application.service.impl;

import com.example.demo.starter.module.profile.application.dto.ProfileDto;
import com.example.demo.starter.module.profile.application.service.ProfileService;
import com.example.demo.starter.module.profile.domain.entity.Profile;
import com.example.demo.starter.module.profile.infrastructure.repository.ProfileRepository;
import com.example.demo.starter.shared.base.configuration.mapper.Mapper;
import com.example.demo.starter.shared.base.service.impl.BaseServiceImpl;
import com.example.demo.starter.shared.util.response.ServiceResponse;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public ServiceResponse<List<ProfileDto>> getByUser(UUID userId) {
        List<Profile> profiles = repository.findByUserId(userId);
        List<ProfileDto> dtoList = profiles.stream().map(mapper::toDto).toList();
        return ServiceResponse.success(dtoList, 200);
    }

    @Override
    public ServiceResponse<ProfileDto> create(ProfileDto dto) {
        Profile profile = Profile.create(dto.getUserId());
        Profile created = repository.save(profile);
        return ServiceResponse.success(mapper.toDto(created), 200);
    }

    @Override
    protected void updateEntity(ProfileDto dto, Profile entity) {

    }
}
