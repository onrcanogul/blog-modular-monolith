package com.example.demo.starter.module.category.infrastructure.repository;

import com.example.demo.starter.module.category.domain.entity.Category;
import com.example.demo.starter.shared.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BaseRepository<Category> {
}
