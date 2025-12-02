package com.example.demo.starter.module.profile.application.service;

import com.example.demo.starter.module.profile.application.dto.ProfileDto;
import com.example.demo.starter.module.profile.domain.entity.Profile;
import com.example.demo.starter.shared.base.service.BaseService;
import com.example.demo.starter.shared.util.response.ServiceResponse;

import java.util.UUID;

public interface ProfileService extends BaseService<Profile, ProfileDto> {
    ServiceResponse<ProfileDto> getByUser(UUID userId);
    ServiceResponse<ProfileDto> create(UUID userId);
    ServiceResponse<ProfileDto> addPostCount(UUID userId);
}
