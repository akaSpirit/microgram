package com.example.microgram.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private String text;
    private LocalDateTime commentDateTime;

    public Comment(String text) {
        this.text = text;
        this.commentDateTime = LocalDateTime.now();
    }
}
