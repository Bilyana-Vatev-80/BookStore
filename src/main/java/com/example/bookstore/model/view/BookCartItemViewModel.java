package com.example.bookstore.model.view;

import java.math.BigDecimal;

public class BookCartItemViewModel {

    private Long id;
    private String title;
    private String pictureUrl;
    private BigDecimal price;
    private Long authorId;
    private String authorFirstName;
    private String authorLastName;

    public BookCartItemViewModel() {
    }

    public Long getId() {
        return id;
    }

    public BookCartItemViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookCartItemViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public BookCartItemViewModel setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BookCartItemViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public BookCartItemViewModel setAuthorId(Long authorId) {
        this.authorId = authorId;
        return this;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public BookCartItemViewModel setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
        return this;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public BookCartItemViewModel setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
        return this;
    }
}
