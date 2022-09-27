package com.example.microgram.dao;

import com.example.microgram.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public List<UserDto> getAllUsers() {
        String sql = "select * from users";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserDto.class));
    }

    public UserDto findByName(String fullname) {
        String sql = "select * from users where fullname = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(UserDto.class), fullname);
    }

    public UserDto findByNickname(String nickname) {
        String sql = "select * from users where nickname = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(UserDto.class), nickname);
    }

    public UserDto findByEmail(String email) {
        String sql = "select * from users where email = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(UserDto.class), email);
    }

    public String registration(String fullname, String nickname, String email, String password) {
        String sql = "insert into users(fullname, nickname, email, password) VALUES (?, ?, ?, ?)";
        var result = jdbcTemplate.update(sql, fullname, nickname, email, password);
        if (result == 0) {
            return "try again";
        }
        return "registration successful";
    }

    public UserDto auth(String nickname, String password) {
        String sql = "select * from users where nickname = ? and password = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(UserDto.class), nickname, password);
    }

}
