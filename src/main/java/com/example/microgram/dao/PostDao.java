package com.example.microgram.dao;

import com.example.microgram.dto.PostDto;
import com.example.microgram.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
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

    public int deleteById(int id) {
        String sql = "delete from posts where id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public void save(Post post) {
        String sql = "insert into posts(photo, description) " +
                "values(?,?,current_timestamp)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, post.getPhoto());
            ps.setString(2, post.getDescription());
            return ps;
        });
    }
}
