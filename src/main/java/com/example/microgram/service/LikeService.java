package com.example.microgram.service;

import com.example.microgram.dao.LikeDao;
import com.example.microgram.entity.Like;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeDao likeDao;

    public List<Like> getLikes() {
        return likeDao.getAllLikes();
    }
}
