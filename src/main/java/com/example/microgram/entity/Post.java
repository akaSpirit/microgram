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
public class Post {
    private String photo;
    private String description;
    private LocalDateTime postDateTime;

    public Post(String photo, String description) {
        this.photo = photo;
        this.description = description;
        this.postDateTime = LocalDateTime.now();
    }
}
