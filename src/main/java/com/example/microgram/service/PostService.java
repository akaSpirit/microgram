package com.example.microgram.service;

import com.example.microgram.dao.PostDao;
import com.example.microgram.dto.PostDto;
import com.example.microgram.entity.Post;
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

    public PostDto addPost(PostDto postDto) {
        var post = Post.builder()
                .photo(postDto.getPhoto())
                .description(postDto.getDescription())
                .build();
        postDao.save(post);
        return PostDto.from(post);
    }
}
