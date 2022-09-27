package com.example.microgram.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostImage {
    private Long id;
    private String name;

    @JsonProperty("image_data")
    private byte[] imageData;

    public PostImage generateNoImage(){
        return PostImage.builder().name("-no-image").build();
    }
}
