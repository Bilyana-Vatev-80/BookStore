package com.example.bookstore.model.view;

import java.math.BigDecimal;
import java.util.List;

public class BookSummaryViewModel {

    private Long id;
    private String title;
    private String pictureUrl;
    private Integer copies;
    private BigDecimal price;
    private String language;
    private List<String> categories;
    private String author;
    private Long authorId;

    public BookSummaryViewModel() {
    }

    public Long getId() {
        return id;
    }

    public BookSummaryViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookSummaryViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public BookSummaryViewModel setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public BookSummaryViewModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BookSummaryViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public BookSummaryViewModel setLanguage(String language) {
        this.language = language;
        return this;
    }

    public List<String> getCategories() {
        return categories;
    }

    public BookSummaryViewModel setCategories(List<String> categories) {
        this.categories = categories;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BookSummaryViewModel setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public BookSummaryViewModel setAuthorId(Long authorId) {
        this.authorId = authorId;
        return this;
    }
}
