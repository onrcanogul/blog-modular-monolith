package com.example.demo.starter.shared.base.service;

import com.example.demo.starter.shared.base.dto.BaseDto;
import com.example.demo.starter.shared.base.entity.BaseEntity;
import com.example.demo.starter.shared.util.response.NoContent;
import com.example.demo.starter.shared.util.response.ServiceResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface BaseService<T extends BaseEntity, D extends BaseDto> {
    public ServiceResponse<List<D>> get(int page, int size);
    public ServiceResponse<D> getSingle(UUID id);
    public ServiceResponse<D> create(D dto);
    public ServiceResponse<D> update(D dto, UUID id);
    public ServiceResponse<NoContent> delete(UUID id);
}
