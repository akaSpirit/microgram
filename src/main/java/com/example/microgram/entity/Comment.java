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
public class Comment {
    private String text;
    private LocalDateTime commentDateTime;

    public Comment(String text) {
        this.text = text;
        this.commentDateTime = LocalDateTime.now();
    }
}
