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

    @GetMapping("/fullname/{fullname}")
    public ResponseEntity<UserDto> getUserByName(@PathVariable String fullname) {
        return new ResponseEntity<>(userService.getUserByName(fullname), HttpStatus.OK);
    }

    @GetMapping("/nickname/{nickname}")
    public ResponseEntity<UserDto> getUserByNickname(@PathVariable String nickname) {
        return new ResponseEntity<>(userService.getUserByNickname(nickname), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/exist/{email}")
    public ResponseEntity<String> existUserByEmail(@PathVariable String email){
        return new ResponseEntity<>(userService.existsUserByEmail(email), HttpStatus.OK);
    }
}
