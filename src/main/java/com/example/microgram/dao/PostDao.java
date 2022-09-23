package com.example.microgram.dao;

import com.example.microgram.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PostDao {
    private final JdbcTemplate jdbcTemplate;

    public List<PostDto> getAllPosts() {
        String sql = "select * from posts";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PostDto.class));
    }

    public List<PostDto> findUserPosts(int user_id) {
        String sql = "select p.photo, p.description, p.postDateTime\n" +
                "from posts p\n" +
                "inner join users u on p.user_id = u.id\n" +
                "where u.id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PostDto.class), user_id);
    }

    public List<PostDto> findPostsBySubs(int user_id) {
        String sql = "select p.photo, p.description, p.postDateTime\n" +
                "from posts p\n" +
                "inner join subs s on s.user_id = p.user_id\n" +
                "inner join users u on u.id = s.follower_id\n" +
                "where u.id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PostDto.class), user_id);
    }
}
