package com.example.microgram.dto;

import com.example.microgram.entity.Post;
import com.example.microgram.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikeDto {
    private User userLiked;
    private Post postLiked;
    private LocalDateTime likeDateTime;
}
