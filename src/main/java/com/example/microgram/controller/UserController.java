package com.example.microgram.controller;

import com.example.microgram.dto.UserDto;
import com.example.microgram.entity.User;
import com.example.microgram.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> users() {
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
