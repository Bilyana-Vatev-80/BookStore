package com.example.bookstore.serice.impl;

import com.example.bookstore.repository.CartRepository;
import com.example.bookstore.serice.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final CartRepository cartRepository;

    public ShoppingCartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public void deleteBookFromAllShoppingCarts(Long id) {
        cartRepository.deleteAllByBookId(id);
    }
}
