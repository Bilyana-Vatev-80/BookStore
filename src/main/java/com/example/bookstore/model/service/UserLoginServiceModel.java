package com.example.bookstore.model.service;

public class UserLoginServiceModel {

    private String username;
    private String password;

    public UserLoginServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
