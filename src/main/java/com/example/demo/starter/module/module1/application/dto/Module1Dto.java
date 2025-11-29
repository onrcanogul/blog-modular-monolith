package com.example.demo.starter.module.module1.application.dto;

import com.example.demo.starter.shared.base.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Module1Dto extends BaseDto {
    private String name;
}
