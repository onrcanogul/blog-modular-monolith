package com.example.demo.starter.module.auth.infrastructure.repository;

import com.example.demo.starter.module.auth.domain.entity.User;
import com.example.demo.starter.shared.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByUsername(String username);
}
