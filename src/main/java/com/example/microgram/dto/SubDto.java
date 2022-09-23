package com.example.microgram.dto;

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
public class SubDto {
    private User follower;
    private User subscribeTo;
    private LocalDateTime subDateTime;
}
