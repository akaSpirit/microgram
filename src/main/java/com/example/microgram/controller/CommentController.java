package com.example.microgram.controller;

import com.example.microgram.dto.CommentDto;
import com.example.microgram.entity.Comment;
import com.example.microgram.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentDto>> comments() {
        return new ResponseEntity<>(commentService.getComments(), HttpStatus.OK);
    }

    @GetMapping("/add/{user_id}&{post_id}")
    public ResponseEntity<String> addNewComment(@PathVariable int user_id, @PathVariable int post_id) {
        return new ResponseEntity<>(commentService.addNewComment(user_id, post_id), HttpStatus.OK);
    }

}
