package com.example.bookstore.model.binding;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthorAddBindingModel {

    @NotBlank(message = "Please enter a valid first name")
    @Size(min = 2, max = 20, message = "First name should be between 2 and 20 characters long")
    private String firstName;

    @NotBlank(message = "Please enter a valid last name")
    @Size(min = 2, max = 20, message = "Last name should be between 2 and 20 characters long")
    private String lastName;
    private String description;
    private MultipartFile image;

    public AuthorAddBindingModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public AuthorAddBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AuthorAddBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AuthorAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public MultipartFile getImage() {
        return image;
    }

    public AuthorAddBindingModel setImage(MultipartFile image) {
        this.image = image;
        return this;
    }
}
