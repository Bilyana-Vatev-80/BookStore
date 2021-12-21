package com.example.bookstore.model.view;

import java.math.BigDecimal;

public class OrderItemViewModel {

    private Long bookId;
    private String bookTitle;
    private String bookPictureUrl;
    private Boolean bookActive;
    private BigDecimal bookPrice;
    private BigDecimal totalPrice;
    private Integer quantity;

    public OrderItemViewModel() {
    }

    public Long getBookId() {
        return bookId;
    }

    public OrderItemViewModel setBookId(Long bookId) {
        this.bookId = bookId;
        return this;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public OrderItemViewModel setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
        return this;
    }

    public String getBookPictureUrl() {
        return bookPictureUrl;
    }

    public OrderItemViewModel setBookPictureUrl(String bookPictureUrl) {
        this.bookPictureUrl = bookPictureUrl;
        return this;
    }

    public Boolean getBookActive() {
        return bookActive;
    }

    public OrderItemViewModel setBookActive(Boolean bookActive) {
        this.bookActive = bookActive;
        return this;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public OrderItemViewModel setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
        return this;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public OrderItemViewModel setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderItemViewModel setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
