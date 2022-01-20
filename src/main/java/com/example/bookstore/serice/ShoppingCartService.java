package com.example.bookstore.serice;

import com.example.bookstore.model.view.CartItemViewModel;

import java.util.List;

public interface ShoppingCartService {

    void deleteBookFromAllShoppingCarts(Long id);

    List<CartItemViewModel> getCartItemsByCustomer(String username);
}
