package com.example.microgram.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String fullname;
    private String nickname;
    private String email;
    private String password;
    private int posts;
    private int followers;
    private int following;
}
