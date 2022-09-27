package com.example.microgram.controller;

import com.example.microgram.dto.PostDto;
import com.example.microgram.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable int postId) {
        if (postService.deletePost(postId))
            return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/add/{photo}&{description}")
    public ResponseEntity<String> addPost(@PathVariable String photo, @PathVariable String description) {
        return new ResponseEntity<>(postService.addPost(photo, description), HttpStatus.OK);
    }
}
