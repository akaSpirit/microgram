package com.example.microgram.service;

import com.example.microgram.dao.CommentDao;
import com.example.microgram.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentDao commentDao;

    public List<Comment> getComments() {
        return commentDao.getAllComments();
    }
}
