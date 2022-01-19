package com.example.bookstore.serice.impl;

import com.example.bookstore.repository.WishlistRepository;
import com.example.bookstore.serice.WishlistService;
import org.springframework.stereotype.Service;

@Service
public class WishlistServiceImpl implements WishlistService {

    private final WishlistRepository wishlistRepository;

    public WishlistServiceImpl(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    @Override
    public void deleteBookFromAllWishlist(Long id) {
        wishlistRepository.deleteAllByBookId(id);
    }
}
