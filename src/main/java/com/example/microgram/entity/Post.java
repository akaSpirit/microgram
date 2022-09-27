package com.example.microgram.entity;

import com.example.microgram.utils.Generator;
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
    private String description = Generator.makeDescription();
    private LocalDateTime postDateTime = LocalDateTime.now();
}
