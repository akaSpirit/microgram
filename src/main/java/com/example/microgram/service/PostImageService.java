package com.example.microgram.service;


import com.example.microgram.dao.PostImageDao;
import com.example.microgram.dto.PostImageDto;
import com.example.microgram.entity.PostImage;
import com.example.microgram.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PostImageService {
    private final PostImageDao postImageDao;

    public PostImageDto addImage(MultipartFile file) {
        byte[] data = new byte[0];
        try {
            data = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (data.length == 0) {
            // TODO return no content or something or throw exception
            //  which will be processed on controller layer
        }

        PostImage image = PostImage.builder().imageData(data).build();

        var savedPostId = postImageDao.save(image);

        return PostImageDto.builder()
                .imageId(savedPostId)
                .build();
    }

    public Resource getById(Long imageId) {
        PostImage postImage = postImageDao.findById(imageId)
                .orElseThrow(() -> new ResourceNotFoundException("Post Image with " + imageId + " doesn't exists!"));
        return new ByteArrayResource(postImage.getImageData());
    }
}
