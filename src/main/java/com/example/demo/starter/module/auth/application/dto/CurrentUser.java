package com.example.demo.starter.module.auth.application.dto;

import java.util.List;
import java.util.UUID;

public record CurrentUser(UUID id, String username, List<String> roles) implements java.io.Serializable {}
