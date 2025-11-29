package com.example.demo.starter.module.category.domain.entity;

import com.example.demo.starter.shared.kernel.domain.AggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(name = "categories")
public class Category extends AggregateRoot {
    private String name;
}
