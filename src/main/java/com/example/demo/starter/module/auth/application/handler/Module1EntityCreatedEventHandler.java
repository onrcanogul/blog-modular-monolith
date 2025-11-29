package com.example.demo.starter.module.auth.application.handler;

import com.example.demo.starter.module.module1.domain.event.Module1CreatedEvent;
import com.example.demo.starter.shared.kernel.event.domain.DomainEventHandler;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Module1EntityCreatedEventHandler implements DomainEventHandler<Module1CreatedEvent> {
    @Override
    @EventListener
    public void handle(Module1CreatedEvent event) {
        //do something
    }
}
