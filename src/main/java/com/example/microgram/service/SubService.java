package com.example.microgram.service;

import com.example.microgram.dao.SubDao;
import com.example.microgram.entity.Sub;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubService {
    private final SubDao subDao;

    public List<Sub> getSubs() {return subDao.getAllSubs();}
}
