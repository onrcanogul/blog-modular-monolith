package com.example.demo.starter.module.module1.application.service.impl;


import com.example.demo.starter.module.module1.application.dto.Module1Dto;
import com.example.demo.starter.module.module1.application.service.Module1Service;
import com.example.demo.starter.module.module1.domain.entity.Module1Entity;
import com.example.demo.starter.module.module1.infrastructure.repository.Module1Repository;
import com.example.demo.starter.shared.base.configuration.mapper.Mapper;
import com.example.demo.starter.shared.base.service.impl.BaseServiceImpl;
import com.example.demo.starter.shared.kernel.event.domain.DomainEventPublisher;
import com.example.demo.starter.shared.util.response.ServiceResponse;
import org.springframework.stereotype.Service;

@Service
public class Module1ServiceImpl extends BaseServiceImpl<Module1Entity, Module1Dto> implements Module1Service {
    private final Module1Repository repository;
    private final Mapper<Module1Entity, Module1Dto> mapper;
    private final DomainEventPublisher eventPublisher;

    public Module1ServiceImpl(
            Module1Repository repository,
            Mapper<Module1Entity, Module1Dto> mapper, DomainEventPublisher eventPublisher
    ) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
        this.eventPublisher = eventPublisher;
    }

    @Override
    protected void updateEntity(Module1Dto dto, Module1Entity entity) {
        entity.setName(dto.getName());
    }

    @Override
    public ServiceResponse<Module1Dto> create(Module1Dto dto) {
        Module1Entity entity = Module1Entity.create(dto.getName());

        Module1Entity created = repository.save(entity);

        eventPublisher.publishAll(entity.pullEvents());

        return ServiceResponse.success(mapper.toDto(created), 200);
    }
}
