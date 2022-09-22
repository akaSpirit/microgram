package com.example.microgram.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
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
