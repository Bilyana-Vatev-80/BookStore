package com.example.bookstore.model.view;

public class AuthorViewModel {

    private String firstName;
    private String lastName;
    private String description;
    private String pictureUrl;

    public AuthorViewModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public AuthorViewModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AuthorViewModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AuthorViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public AuthorViewModel setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }
}
