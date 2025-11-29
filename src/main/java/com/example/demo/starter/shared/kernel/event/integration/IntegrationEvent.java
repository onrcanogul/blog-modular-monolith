package com.example.demo.starter.shared.kernel.event.integration;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public abstract class IntegrationEvent {

    private final UUID idempotencyKey;

    private final Instant occurredOn;

    private final String source;

    private final int version;

    protected IntegrationEvent(String source, int version) {
        this.idempotencyKey = UUID.randomUUID();
        this.occurredOn = Instant.now();
        this.source = source;
        this.version = version;
    }

    public abstract String topicName();
}
