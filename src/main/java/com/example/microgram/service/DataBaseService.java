package com.example.microgram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class DataBaseService {
    private final JdbcTemplate jdbcTemplate;

    private void createUserTable() throws SQLException {
        jdbcTemplate.execute("create table if not exists users (id bigserial PRIMARY KEY, fullname TEXT, nickname TEXT, email TEXT, password TEXT)");
        jdbcTemplate.execute("insert into users(fullname, nickname, email, password) VALUES ('Layla Rogers', 'layla', 'layla@gmail.com', 'layla123')," +
                "('Rohan Nash', 'rohan', 'rohan@gmail.com', 'rohan123')," +
                "('Trystan North', 'trystan', 'trystan@gmail.com', 'trystan')");
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
        jdbcTemplate.execute("create table if not exists posts (id bigserial PRIMARY KEY, photo TEXT, description TEXT, postDateTime timestamp without time zone, user_id int not null references users(id))");
        jdbcTemplate.execute("insert into posts(photo, description, postDateTime, user_id) VALUES ('photo1', 'description1', current_timestamp, 1)," +
                "('photo2', 'description2', current_timestamp, 2)," +
                "('photo3', 'description3', current_timestamp, 3)");
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

    private void createCommentTable() throws SQLException {
        jdbcTemplate.execute("create table if not exists comments (id bigserial PRIMARY KEY, text TEXT, commentDateTime timestamp  without time zone, user_id int not null references users(id), post_id int not null references posts(id))");
        jdbcTemplate.execute("insert into comments(text, commentDateTime, user_id, post_id) VALUES ('comment1', current_timestamp, 1, 2)," +
                "('comment2', current_timestamp, 2, 3)," +
                "('comment3', current_timestamp, 3, 1)");
    }

    public String shouldCreateCommentTable() {
        try {
            createCommentTable();
            jdbcTemplate.execute("select * from comments");
            return "OK";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    private void createLikeTable() throws SQLException {
        jdbcTemplate.execute("create table if not exists likes (id bigserial PRIMARY KEY, likeDateTime timestamp without time zone, user_id int not null references users(id), post_id int not null references posts(id))");
        jdbcTemplate.execute("insert into likes(likeDateTime, user_id, post_id) VALUES (current_timestamp, 1, 2)," +
                "(current_timestamp, 2, 1)," +
                "(current_timestamp, 3, 1)");
    }

    public String shouldCreateLikeTable() {
        try {
            createLikeTable();
            jdbcTemplate.execute("select * from likes");
            return "OK";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    private void createSubTable() throws SQLException {
        jdbcTemplate.execute("create table if not exists subs (id bigserial PRIMARY KEY, subDateTime timestamp without time zone, user_id int not null references users(id), follower_id int not null references users(id))");
        jdbcTemplate.execute("insert into subs(subDateTime, user_id, follower_id) VALUES (current_timestamp, 1, 2)," +
                "(current_timestamp, 2, 1)," +
                "(current_timestamp, 3, 1)");
    }

    public String shouldCreateSubTable() {
        try {
            createSubTable();
            jdbcTemplate.execute("select * from subs");
            return "OK";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
