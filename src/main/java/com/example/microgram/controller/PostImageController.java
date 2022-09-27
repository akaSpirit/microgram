package com.example.microgram.controller;

import com.example.microgram.dto.PostImageDto;
import com.example.microgram.service.PostImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class PostImageController {
    private final PostImageService postImageService;

    @PostMapping
    public PostImageDto addPostImage(@RequestParam("file") MultipartFile file) {
        return postImageService.addImage(file);
    }

    @GetMapping("/{imageId}")
    public ResponseEntity<Resource> serveFile(@PathVariable Long imageId) {
        Resource resource = postImageService.getById(imageId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE)
                .body(resource);
    }
}
