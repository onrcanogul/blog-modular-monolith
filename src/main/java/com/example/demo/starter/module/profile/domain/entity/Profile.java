package com.example.demo.starter.module.profile.domain.entity;

import com.example.demo.starter.shared.kernel.domain.AggregateRoot;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@Table(name = "profiles")
@NoArgsConstructor @AllArgsConstructor
public class Profile extends AggregateRoot {
    private UUID userId;
    private int postCount;
    private int commentCount;
    private int rating;
    private int postViewCount;
    private int postLikeCount;
    private int profileViewCount;

    public static Profile create(UUID userId) {
        Profile profile = new Profile();
        profile.userId = userId;
        profile.postLikeCount = 0;
        profile.profileViewCount = 0;
        profile.postViewCount = 0;
        profile.postCount = 0;
        profile.rating = 0;
        profile.commentCount = 0;
        return profile;
    }

    public void addPost() {
        this.postCount++;
    }

    public void addComment() {
        this.commentCount++;
    }

    public void addPostView() {
        this.postViewCount++;
    }

    public void addProfileView() {
        this.profileViewCount++;
    }

    public void addPostLike() {
        this.postLikeCount++;
    }

}
