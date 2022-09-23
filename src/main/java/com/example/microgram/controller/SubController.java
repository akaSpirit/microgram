package com.example.microgram.controller;

import com.example.microgram.entity.Sub;
import com.example.microgram.service.SubService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subs")
@AllArgsConstructor
public class SubController {
    private final SubService subService;

    @GetMapping
    public ResponseEntity<List<Sub>> subs() {
        return new ResponseEntity<>(subService.getSubs(), HttpStatus.OK);
    }
}
