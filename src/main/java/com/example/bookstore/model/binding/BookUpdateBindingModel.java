package com.example.bookstore.model.binding;

import com.example.bookstore.model.validator.PastOrCurrentYear;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

public class BookUpdateBindingModel {

    private Long id;

    @NotBlank(message = "Please enter a valid isbn")
    private String isbn;

    private String title;

    private String description;

    private MultipartFile image;

    @NotNull(message = "Copies count should be a positive number")
    @Positive(message = "Copies count should be a positive number")
    private Integer copies;

    @PastOrCurrentYear
    private Integer releaseYear;

    @NotNull(message = "Price should be a positive number")
    @Positive(message = "Price should be a positive number")
    private BigDecimal price;

    @NotEmpty(message = "Please select language")
    private String language;

    @NotEmpty(message = "Please select categories")
    private List<String> categories;

    @NotEmpty(message = "Please select publishing house")
    private String publishingHouse;

    @NotBlank(message = "Please enter author first name")
    private String authorFirstName;

    @NotBlank(message = "Please enter author last name")
    private String authorLastName;

    public BookUpdateBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public BookUpdateBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookUpdateBindingModel setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookUpdateBindingModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BookUpdateBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public MultipartFile getImage() {
        return image;
    }

    public BookUpdateBindingModel setImage(MultipartFile image) {
        this.image = image;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public BookUpdateBindingModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public BookUpdateBindingModel setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BookUpdateBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public BookUpdateBindingModel setLanguage(String language) {
        this.language = language;
        return this;
    }

    public List<String> getCategories() {
        return categories;
    }

    public BookUpdateBindingModel setCategories(List<String> categories) {
        this.categories = categories;
        return this;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public BookUpdateBindingModel setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
        return this;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public BookUpdateBindingModel setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
        return this;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public BookUpdateBindingModel setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
        return this;
    }
}
