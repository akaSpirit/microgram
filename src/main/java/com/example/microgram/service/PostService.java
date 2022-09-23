package com.example.microgram.service;

import com.example.microgram.dao.PostDao;
import com.example.microgram.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostDao postDao;

    public List<Post> getPosts() {return postDao.getAllPosts();}
}
