package com.example.microgram.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Like {
    private User userLiked;
    private Post postLiked;
    private LocalDateTime likeDateTime;

    public Like(User userLiked, Post postLiked) {
        this.userLiked = userLiked;
        this.postLiked = postLiked;
        this.likeDateTime = LocalDateTime.now();
    }
}
