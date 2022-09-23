package com.example.microgram.controller;

import com.example.microgram.entity.*;
import com.example.microgram.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
@RequiredArgsConstructor
public class MainController {
    private final CommentService commentService;
    private final LikeService likeService;
    private final PostService postService;
    private final SubService subService;
    private final UserService userService;
    private final DataBaseService dataBaseService;
    @GetMapping("/create")
    public ResponseEntity<String> createTable() {
        return new ResponseEntity<>(dataBaseService.shouldCreateTable(), HttpStatus.OK);
    }
    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> comments() {
        return new ResponseEntity<>(commentService.getComments(), HttpStatus.OK);
    }
    @GetMapping("/likes")
    public ResponseEntity<List<Like>> likes() {
        return new ResponseEntity<>(likeService.getLikes(), HttpStatus.OK);
    }
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> posts() {
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }
    @GetMapping("/subs")
    public ResponseEntity<List<Sub>> subs() {
        return new ResponseEntity<>(subService.getSubs(), HttpStatus.OK);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> users() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/findname/{fullname}")
    public ResponseEntity<User> getUserByName(@PathVariable String fullname) {
        return new ResponseEntity<>(userService.getUserByName(fullname), HttpStatus.OK);
    }

    @GetMapping("/findnick/{nickname}")
    public ResponseEntity<User> getUserByNickname(@PathVariable String nickname) {
        return new ResponseEntity<>(userService.getUserByNickname(nickname), HttpStatus.OK);
    }

    @GetMapping("/findemail/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }
}
