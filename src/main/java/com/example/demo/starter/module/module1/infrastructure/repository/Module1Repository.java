package com.example.demo.starter.module.module1.infrastructure.repository;

import com.example.demo.starter.module.module1.domain.entity.Module1Entity;
import com.example.demo.starter.shared.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Module1Repository extends BaseRepository<Module1Entity> {
}
