package com.example.demo.starter.module.auth.application.service.impl;

import com.example.demo.starter.module.auth.application.dto.CurrentUser;
import com.example.demo.starter.module.auth.application.dto.UserDto;
import com.example.demo.starter.module.auth.application.service.UserService;
import com.example.demo.starter.module.auth.domain.entity.User;
import com.example.demo.starter.module.auth.infrastructure.repository.UserRepository;
import com.example.demo.starter.shared.exception.NotFoundException;
import com.example.demo.starter.shared.base.configuration.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final Mapper<User, UserDto> mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Mapper<User, UserDto> mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws NotFoundException {
        User user = userRepository
                .findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username: " + username));

        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }

    @Override
    public UserDto getById(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User Not Found"));
        return mapper.toDto(user);
    }

    @Override
    public UUID getCurrentUserId() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof CurrentUser cu) return cu.id();
        return null;
    }
}
