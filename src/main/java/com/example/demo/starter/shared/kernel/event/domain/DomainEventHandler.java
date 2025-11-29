package com.example.demo.starter.shared.kernel.event.domain;

public interface DomainEventHandler<T extends DomainEvent> {
    void handle(T event);
}