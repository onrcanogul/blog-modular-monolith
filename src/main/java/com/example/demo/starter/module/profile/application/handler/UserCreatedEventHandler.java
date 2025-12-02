package com.example.demo.starter.module.profile.application.handler;

import com.example.demo.starter.module.auth.domain.event.AuthUserCreatedEvent;
import com.example.demo.starter.module.profile.application.service.ProfileService;
import com.example.demo.starter.shared.kernel.event.domain.DomainEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCreatedEventHandler implements DomainEventHandler<AuthUserCreatedEvent> {
    private final ProfileService service;

    @Override
    public void handle(AuthUserCreatedEvent event) {
        service.create(event.getUserId());
    }
}
