package com.example.microgram.controller;

import com.example.microgram.dto.LikeDto;
import com.example.microgram.entity.Like;
import com.example.microgram.service.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/likes")
@AllArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @GetMapping
    public ResponseEntity<List<LikeDto>> likes() {
        return new ResponseEntity<>(likeService.getLikes(), HttpStatus.OK);
    }

    @GetMapping("/likepost/{user_id}&{post_id}")
    public ResponseEntity<String> checkLikeOnPost(@PathVariable int user_id, @PathVariable int post_id) {
        return new ResponseEntity<>(likeService.checkLikeOnPost(user_id, post_id), HttpStatus.OK);
    }
}
