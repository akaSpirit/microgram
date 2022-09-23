package com.example.microgram.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    public static final User EMPTY = new User("full name","nickname", "email@gmail.com", "password");

    private String fullname;
    private String nickname;
    private String email;
    private String password;
    private int posts;
    private int followers;
    private int following;

    public User(String fullname, String nickname, String email, String password) {
        this.fullname = fullname;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }
}
