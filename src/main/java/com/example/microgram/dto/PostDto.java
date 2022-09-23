package com.example.microgram.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PostDto {
    private String photo;
    private String description;
    private LocalDateTime postDateTime;
}
