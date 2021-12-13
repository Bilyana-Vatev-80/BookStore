package com.example.bookstore.model.binding;

import com.example.bookstore.model.validator.PasswordsMatch;
import com.example.bookstore.model.validator.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@PasswordsMatch(
        password = "password",
        confirmPassword = "confirmPassword"
)
public class UserRegisterBindingModel {

    @NotBlank(message = "Please enter a valid first name")
    @Size(min = 2, max = 20, message = "First name should be between 2 and 20 characters long")
    private String firstName;

    @NotBlank(message = "Please enter a valid last name")
    @Size(min = 2, max = 20, message = "Last name should be between 2 and 20 characters long")
    private String lastName;

    @UniqueUsername

    @NotBlank(message = "Please enter a valid username")
    @Size(min = 2, max = 20, message = "Username should be between 2 and 20 characters long")
    private String username;

    @NotBlank(message = "Please enter a valid email")
    @Email(message = "Please enter a valid email")
    private String email;

    @NotBlank(message = "Please enter your full address for delivery")
    private String address;


    @NotBlank(message = "Please enter a valid password")
    @Size(min = 2, max = 20, message = "Password should be between 2 and 20 characters long")
    private String password;


    @NotBlank(message = "Please confirm your password")
    @Size(min = 2, max = 20, message = "Password should be between 2 and 20 characters long")
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserRegisterBindingModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
