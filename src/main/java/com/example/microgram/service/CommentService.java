package com.example.microgram.service;

import com.example.microgram.dao.CommentDao;
import com.example.microgram.dto.CommentDto;
import com.example.microgram.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentDao commentDao;

    public List<CommentDto> getComments() {
        return commentDao.getAllComments();
    }

    public String addNewComment(String comment, int user_id, int post_id) {
        return commentDao.addNewComment(comment, user_id, post_id);
    }

    public String deleteComment(int id) {
        return commentDao.deleteComment(id);
    }
}
