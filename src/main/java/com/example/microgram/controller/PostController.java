package com.example.microgram.controller;

import com.example.microgram.entity.Post;
import com.example.microgram.service.CommentService;
import com.example.microgram.service.LikeService;
import com.example.microgram.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {
    private final PostService postService;
    private final LikeService likeService;
    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Post>> posts() {
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }
}
