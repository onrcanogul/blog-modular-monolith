package com.example.demo.starter.module.category.application.dto;

import com.example.demo.starter.shared.base.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class CategoryDto extends BaseDto {
    private String name;
}
