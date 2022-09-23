package com.example.microgram.controller;

import com.example.microgram.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
@RequiredArgsConstructor
public class MainController {
    private final DataBaseService dataBaseService;
    @GetMapping("/createusers")
    public ResponseEntity<String> createUsersTable() {
        return new ResponseEntity<>(dataBaseService.shouldCreateUserTable(), HttpStatus.OK);
    }

    @GetMapping("/createposts")
    public ResponseEntity<String> createPostsTable() {
        return new ResponseEntity<>(dataBaseService.shouldCreatePostTable(), HttpStatus.OK);
    }
}
