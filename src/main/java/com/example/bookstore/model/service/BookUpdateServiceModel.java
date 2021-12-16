package com.example.bookstore.model.service;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

public class BookUpdateServiceModel {

    private Long id;
    private String isbn;
    private String description;
    private MultipartFile image;
    private Integer copies;
    private Integer releaseYear;
    private BigDecimal price;
    private String language;
    private List<String> categories;
    private String publishingHouseName;
    private String authorFirstName;
    private String authorLastName;

    public BookUpdateServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public BookUpdateServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookUpdateServiceModel setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BookUpdateServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public MultipartFile getImage() {
        return image;
    }

    public BookUpdateServiceModel setImage(MultipartFile image) {
        this.image = image;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public BookUpdateServiceModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public BookUpdateServiceModel setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BookUpdateServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public BookUpdateServiceModel setLanguage(String language) {
        this.language = language;
        return this;
    }

    public List<String> getCategories() {
        return categories;
    }

    public BookUpdateServiceModel setCategories(List<String> categories) {
        this.categories = categories;
        return this;
    }

    public String getPublishingHouseName() {
        return publishingHouseName;
    }

    public BookUpdateServiceModel setPublishingHouseName(String publishingHouseName) {
        this.publishingHouseName = publishingHouseName;
        return this;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public BookUpdateServiceModel setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
        return this;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public BookUpdateServiceModel setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
        return this;
    }
}
