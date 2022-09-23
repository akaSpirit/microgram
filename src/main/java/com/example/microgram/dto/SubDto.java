package com.example.microgram.dto;

import com.example.microgram.entity.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SubDto {
    private User follower;
    private User subscribeTo;
    private LocalDateTime subDateTime;
}
