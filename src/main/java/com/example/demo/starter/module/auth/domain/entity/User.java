package com.example.demo.starter.module.auth.domain.entity;

import com.example.demo.starter.module.auth.domain.event.AuthUserCreatedEvent;
import com.example.demo.starter.shared.base.entity.BaseEntity;
import com.example.demo.starter.shared.kernel.domain.AggregateRoot;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(name = "users")
@SQLRestriction("is_deleted = false")
public class User extends AggregateRoot {
    private String username;
    private String email;
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    public static User create(String email, String username, String encodedPassword) {
        User user = new User();
        UUID userId = UUID.randomUUID();
        user.setRoles(List.of("USER"));
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(encodedPassword);
        user.registerEvent(new AuthUserCreatedEvent(userId));
        return user;
    }
}
