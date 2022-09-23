package com.example.microgram.service;

import com.example.microgram.utils.Generator;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DataBaseService {
    private final JdbcTemplate jdbcTemplate;

    private void createUserTable() throws SQLException {
        jdbcTemplate.execute("create table if not exists users (id INTEGER PRIMARY KEY, fullname TEXT, nickname TEXT, email TEXT, password TEXT)");
        jdbcTemplate.execute("insert into users VALUES (1, 'Layla Rogers', 'layla', 'layla@gmail.com', 'layla123')");
        jdbcTemplate.execute("insert into users VALUES (2, 'Rohan Nash', 'rohan', 'rohan@gmail.com', 'rohan123')");
        jdbcTemplate.execute("insert into users VALUES (3, 'Trystan North', 'trystan', 'trystan@gmail.com', 'trystan')");
    }

    public String shouldCreateUserTable() {
        try {
            createUserTable();
            jdbcTemplate.execute("select * from users");
            return "OK";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    private void createPostTable() throws SQLException {
        jdbcTemplate.execute("create table if not exists posts (id INTEGER PRIMARY KEY, photo TEXT, description TEXT, postDateTime TEXT)");
        jdbcTemplate.execute("insert into posts VALUES (1, 'photo', 'description', 'postDateTime')");
        jdbcTemplate.execute("insert into posts VALUES (2, 'photo', 'description', 'postDateTime')");
        jdbcTemplate.execute("insert into posts VALUES (3, 'photo', 'description', 'postDateTime')");
    }

    public String shouldCreatePostTable() {
        try {
            createPostTable();
            jdbcTemplate.execute("select * from posts");
            return "OK";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
