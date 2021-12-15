package com.example.bookstore.model.service;

import org.springframework.web.multipart.MultipartFile;

public class AuthorAddServiceModel {

    private String firstName;
    private String lastName;
    private String description;
    private MultipartFile image;

    public AuthorAddServiceModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public AuthorAddServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AuthorAddServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AuthorAddServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public MultipartFile getImage() {
        return image;
    }

    public AuthorAddServiceModel setImage(MultipartFile image) {
        this.image = image;
        return this;
    }
}
