package com.example.microgram.service;

import com.example.microgram.dao.UserDao;
import com.example.microgram.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

    public List<User> getUsers() { return userDao.getAllUsers(); }

    public User getUserByName(String fullname) {
        return userDao.findByName(fullname);
    }

    public User getUserByNickname(String nickname) {
        return userDao.findByNickname(nickname);
    }

    public User getUserByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
