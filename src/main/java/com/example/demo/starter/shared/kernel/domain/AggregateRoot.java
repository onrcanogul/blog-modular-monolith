package com.example.demo.starter.shared.kernel.domain;

import com.example.demo.starter.shared.base.entity.BaseEntity;
import com.example.demo.starter.shared.kernel.event.domain.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class AggregateRoot extends BaseEntity {

    private final List<DomainEvent> events = new ArrayList<>();

    protected void registerEvent(DomainEvent event) {
        events.add(event);
    }

    public List<DomainEvent> pullEvents() {
        var copy = List.copyOf(events);
        events.clear();
        return copy;
    }
}

