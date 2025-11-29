package com.example.demo.starter.shared.base.repository;

import com.example.demo.starter.shared.base.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BaseRepository<D extends BaseEntity> extends JpaRepository<D, UUID> {
}
