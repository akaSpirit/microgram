package com.example.microgram.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
