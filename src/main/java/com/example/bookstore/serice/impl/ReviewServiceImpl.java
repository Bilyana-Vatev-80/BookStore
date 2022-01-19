package com.example.bookstore.serice.impl;

import com.example.bookstore.repository.ReviewRepository;
import com.example.bookstore.serice.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void deleteAllReviewsForBook(Long id) {
        reviewRepository.deleteAllByBookId(id);
    }
}
