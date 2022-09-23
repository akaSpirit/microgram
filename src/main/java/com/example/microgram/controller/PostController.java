package com.example.microgram.controller;

import com.example.microgram.dto.PostDto;
import com.example.microgram.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDto>> posts() {
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }

    @GetMapping("/post/{user_id}")
    public ResponseEntity<List<PostDto>> getUserPosts(@PathVariable int user_id) {
        return new ResponseEntity<>(postService.getUserPosts(user_id), HttpStatus.OK);
    }

    @GetMapping("/postsub/{user_id}")
    public ResponseEntity<List<PostDto>> getPostsBySubs(@PathVariable int user_id) {
        return new ResponseEntity<>(postService.getPostsBySubs(user_id), HttpStatus.OK);
    }
}
