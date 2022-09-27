package com.example.microgram.service;

import com.example.microgram.dao.UserDao;
import com.example.microgram.dto.UserDto;
import com.example.microgram.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

    public List<UserDto> getUsers() { return userDao.getAllUsers(); }

    public UserDto getUserByName(String fullname) {
        return userDao.findByName(fullname);
    }

    public UserDto getUserByNickname(String nickname) {
        return userDao.findByNickname(nickname);
    }

    public UserDto getUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public String existsUserByEmail(String email) {
        if (userDao.findByEmail(email) != null) {
            return "There's a user with email: " + email;
        }
        return "There's no user with email: " + email;

    }

    public String registration(String fullname, String nickname, String email, String password) {
        return userDao.registration(fullname, nickname, email, password);
    }

    public UserDto auth(String nickname, String password) {
        return userDao.auth(nickname, password);
    }
}
