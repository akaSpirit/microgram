package com.example.microgram.dto;

import com.example.microgram.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private String photo;
    private String description;
    private LocalDateTime postDateTime;

    public static PostDto from(Post post) {

        return builder()
                .photo(post.getPhoto())
                .description(post.getDescription())
                .build();
    }
}
