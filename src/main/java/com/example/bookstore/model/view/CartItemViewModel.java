package com.example.bookstore.model.view;

import java.math.BigDecimal;

public class CartItemViewModel {

    private Long id;
    private BookCartItemViewModel book;
    private Integer quantity;

    public CartItemViewModel() {
    }

    public Long getId() {
        return id;
    }

    public CartItemViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public BookCartItemViewModel getBook() {
        return book;
    }

    public CartItemViewModel setBook(BookCartItemViewModel book) {
        this.book = book;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public CartItemViewModel setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal calculatePrice(){
        return this.book.getPrice().multiply(BigDecimal.valueOf(this.quantity));
    }
}
