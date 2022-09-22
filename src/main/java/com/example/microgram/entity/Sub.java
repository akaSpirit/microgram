package com.example.microgram.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Sub {
    private User follower;
    private User subscribeTo;
    private LocalDateTime subDateTime;

    public Sub(User follower, User subscribeTo) {
        this.follower = follower;
        this.subscribeTo = subscribeTo;
        this.subDateTime = LocalDateTime.now();
    }
}
