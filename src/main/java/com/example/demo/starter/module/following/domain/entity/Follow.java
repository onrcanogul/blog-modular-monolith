package com.example.demo.starter.module.following.domain.entity;

import com.example.demo.starter.module.following.domain.enumeration.FollowingState;
import com.example.demo.starter.shared.kernel.domain.AggregateRoot;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(name = "following")
public class Follow extends AggregateRoot {
    private UUID followerId;
    private UUID followingId;
    private FollowingState state = FollowingState.PENDING;

    public static Follow create(UUID followerId, UUID followingId) {
        Follow follow = new Follow();
        follow.setFollowerId(followerId);
        follow.setFollowingId(followingId);
        return follow;
    }

    public void accept() {
        this.setState(FollowingState.ACCEPTED);
    }

    public void reject() {
        this.setState(FollowingState.REJECTED);
    }
}
