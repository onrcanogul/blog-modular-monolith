package com.example.demo.starter.module.following.api.model;

import java.util.UUID;

public final record ToggleAnswerRequest (UUID followerId, UUID followingId) {
}
