package com.example.demo.starter.shared.base.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseDto {
    private UUID id;
    private Date createdDate;
    private Date updatedDate;
    private boolean isDeleted;
}