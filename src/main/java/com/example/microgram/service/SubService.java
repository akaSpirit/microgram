package com.example.microgram.service;

import com.example.microgram.dao.SubDao;
import com.example.microgram.dto.SubDto;
import com.example.microgram.entity.Sub;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubService {
    private final SubDao subDao;

    public List<SubDto> getSubs() {return subDao.getAllSubs();}
}
