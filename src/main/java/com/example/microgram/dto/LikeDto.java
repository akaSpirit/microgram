package com.example.microgram.dto;

import com.example.microgram.entity.Post;
import com.example.microgram.entity.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class LikeDto {
    private User userLiked;
    private Post postLiked;
    private LocalDateTime likeDateTime;
}
