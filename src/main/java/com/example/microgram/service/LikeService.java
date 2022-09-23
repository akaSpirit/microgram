package com.example.microgram.service;

import com.example.microgram.dao.LikeDao;
import com.example.microgram.dto.LikeDto;
import com.example.microgram.entity.Like;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeDao likeDao;

    public List<LikeDto> getLikes() {
        return likeDao.getAllLikes();
    }

    public String checkLikeOnPost(int user_id, int post_id) {
        return likeDao.checkLikeOnPost(user_id, post_id);
    }
}
