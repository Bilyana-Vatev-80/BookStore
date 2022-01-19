package com.example.bookstore.serice.impl;

import com.example.bookstore.serice.PagesViewCountService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PagesViewCountServiceImpl implements PagesViewCountService {

    private Map<String, Integer> pagesViewsCount;

    public PagesViewCountServiceImpl() {
        this.pagesViewsCount = new HashMap<>();
    }

    @Override
    public Integer getPageViewsCount(String requestURI) {
        return pagesViewsCount.get(requestURI);
    }
}
