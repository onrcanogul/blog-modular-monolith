package com.example.demo.starter.module.auth.application.dto;

import com.example.demo.starter.shared.base.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserDto extends BaseDto {
    private String username;
    private String email;
}
