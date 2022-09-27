package com.example.microgram.dao;

import com.example.microgram.entity.PostImage;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PostImageDao {
    private final JdbcTemplate jdbcTemplate;

    public Optional<PostImage> findById(Long id) {
        String sql = "select * " +
                "from post_image " +
                "where id = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PostImage.class), id)
        ));
    }

    public Long save(PostImage image) {
        String sql = "insert into post_image(name, poster_data) " +
                "values(?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, image.getName());
            ps.setBytes(2, image.getPosterData());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }
}
