package com.example.microgram.dao;

import com.example.microgram.dto.SubDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubDao {
    private final JdbcTemplate jdbcTemplate;

    public List<SubDto> getAllSubs() {
        String sql = "select * from subs";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SubDto.class));
    }
}
