package com.example.bookstore.model.binding;

import com.example.bookstore.model.validator.UniqueByIsbn;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class BookAddBindingModel {

    @UniqueByIsbn
    @NotBlank(message = "Please enter a valid isbn")
    private String isbn;

    @NotBlank(message = "Please enter a valid title")
    @Size(min = 1, max = 100, message = "Title should be between 1 and 100 characters long")
    private String title;
    private String description;
    private MultipartFile image;

    public BookAddBindingModel() {
    }

    public String getIsbn() {
        return isbn;
    }

    public BookAddBindingModel setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookAddBindingModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BookAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public MultipartFile getImage() {
        return image;
    }

    public BookAddBindingModel setImage(MultipartFile image) {
        this.image = image;
        return this;
    }
}
