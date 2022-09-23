package com.example.microgram.service;

import com.example.microgram.dao.PostDao;
import com.example.microgram.dao.UserDao;
import com.example.microgram.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorizationService {
    private final UserDao userDao;

    public Optional<User> login(String email, String password) {
        // TODO реализовать логику входа в систему
        return Optional.empty();
    }

}
