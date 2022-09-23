package com.example.microgram.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CommentDto {
    private String text;
    private LocalDateTime commentDateTime;
}
