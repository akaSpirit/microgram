package com.example.microgram.dao;

import com.example.microgram.dto.LikeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LikeDao {
    private final JdbcTemplate jdbcTemplate;

    public List<LikeDto> getAllLikes() {
        String sql = "select * from likes";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(LikeDto.class));
    }

    public String checkLikeOnPost(int user_id, int post_id) {
        String sql = "select count(*) from likes\n" +
                "where user_id = ? and post_id = ?";
        var result = jdbcTemplate.queryForObject(sql, Integer.class, user_id, post_id);
        if (result == 0) {
            return "user not liked this post";
        }
        return "user liked this post";
    }
}
