package com.example.microgram.dao;

import com.example.microgram.dto.CommentDto;
import com.example.microgram.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommentDao {
    private final JdbcTemplate jdbcTemplate;

    public List<CommentDto> getAllComments() {
        String sql = "select * from comments";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CommentDto.class));
    }

    public String addNewComment(int user_id, int post_id) {
        String sql = "insert into comments(text, commentDateTime, user_id, post_id) VALUES ('new comment', current_timestamp, ?, ?)";
        var result = jdbcTemplate.update(sql, user_id, post_id);
        if (result == 0) {
            return "user not added new comment";
        }
        return "user added new comment";
    }

    public String deleteComment(int id) {
        String sql = "delete\n" +
                "from comments\n" +
                "where id = ?;\n";
//        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CommentDto.class), id);
        var result = jdbcTemplate.update(sql, id);
        return "comment deleted";
    }
}
