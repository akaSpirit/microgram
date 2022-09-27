package com.example.microgram.service;

import com.example.microgram.dao.PostDao;
import com.example.microgram.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostDao postDao;

    public List<PostDto> getPosts() {return postDao.getAllPosts();}

    public List<PostDto> getUserPosts(int user_id) {
        return postDao.findUserPosts(user_id);
    }

    public List<PostDto> getPostsBySubs(int user_id) {
        return postDao.findPostsBySubs(user_id);
    }

    public boolean deletePost(int id) {
        postDao.deleteById(id);
        return true;
    }

    public String addPost(String photo, String description) {
        return postDao.addPost(photo, description);
    }
}
