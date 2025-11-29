package com.example.demo.starter.shared.kernel.event.integration;

import java.util.UUID;

public interface IdempotencyStore {
    boolean exists(UUID key);
    void save(UUID key);
}
