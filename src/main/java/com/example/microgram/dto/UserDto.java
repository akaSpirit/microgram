package com.example.microgram.dto;

import com.example.microgram.entity.Post;
import com.example.microgram.entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDto {
    private String fullname;
    private String nickname;
    private String email;
    private String password;
    private List<Post> posts;
    private List<User> followers;
    private List<User> following;
}
