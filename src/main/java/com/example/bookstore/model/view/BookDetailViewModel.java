package com.example.bookstore.model.view;

import com.example.bookstore.model.entity.enums.LanguageEnum;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

public class BookDetailViewModel {

    private Long id;
    private String isbn;
    private String title;
    private String description;
    private String pictureUrl;
    private ZonedDateTime addedOn;
    private ZonedDateTime modified;
    private Integer copies;
    private Integer releaseYear;
    private BigDecimal price;
    private LanguageEnum language;
    private List<String> categories;
    private PublishingHouseViewModel publishingModel;
    private String author;
    private Long authorId;
    private String creator;

    public BookDetailViewModel() {
    }

    public Long getId() {
        return id;
    }

    public BookDetailViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookDetailViewModel setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookDetailViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BookDetailViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public BookDetailViewModel setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

    public ZonedDateTime getAddedOn() {
        return addedOn;
    }

    public BookDetailViewModel setAddedOn(ZonedDateTime addedOn) {
        this.addedOn = addedOn;
        return this;
    }

    public ZonedDateTime getModified() {
        return modified;
    }

    public BookDetailViewModel setModified(ZonedDateTime modified) {
        this.modified = modified;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public BookDetailViewModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public BookDetailViewModel setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BookDetailViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LanguageEnum getLanguage() {
        return language;
    }

    public BookDetailViewModel setLanguage(LanguageEnum language) {
        this.language = language;
        return this;
    }

    public List<String> getCategories() {
        return categories;
    }

    public BookDetailViewModel setCategories(List<String> categories) {
        this.categories = categories;
        return this;
    }

    public PublishingHouseViewModel getPublishingModel() {
        return publishingModel;
    }

    public BookDetailViewModel setPublishingModel(PublishingHouseViewModel publishingModel) {
        this.publishingModel = publishingModel;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BookDetailViewModel setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public BookDetailViewModel setAuthorId(Long authorId) {
        this.authorId = authorId;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public BookDetailViewModel setCreator(String creator) {
        this.creator = creator;
        return this;
    }
}
