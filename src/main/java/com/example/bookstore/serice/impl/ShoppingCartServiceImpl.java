package com.example.bookstore.serice.impl;

import com.example.bookstore.model.view.CartItemViewModel;
import com.example.bookstore.repository.CartRepository;
import com.example.bookstore.serice.ShoppingCartService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final CartRepository cartRepository;
    private final ModelMapper modelMapper;

    public ShoppingCartServiceImpl(CartRepository cartRepository, ModelMapper modelMapper) {
        this.cartRepository = cartRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void deleteBookFromAllShoppingCarts(Long id) {
        cartRepository.deleteAllByBookId(id);
    }

    @Override
    public List<CartItemViewModel> getCartItemsByCustomer(String username) {
        return cartRepository.findAllByCustomerUsername(username)
                .stream()
                .map(cartEntity -> modelMapper
                        .map(cartEntity, CartItemViewModel.class))
                .collect(Collectors.toList());
    }
}
