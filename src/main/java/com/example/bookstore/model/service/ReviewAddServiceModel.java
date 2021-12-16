package com.example.bookstore.model.service;

public class ReviewAddServiceModel {

    private Long bookNum;
    private String nickname;
    private String title;
    private String textContent;
    private String rating;
    private String author;

    public ReviewAddServiceModel() {
    }

    public Long getBookNum() {
        return bookNum;
    }

    public ReviewAddServiceModel setBookNum(Long bookNum) {
        this.bookNum = bookNum;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public ReviewAddServiceModel setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ReviewAddServiceModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public ReviewAddServiceModel setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public String getRating() {
        return rating;
    }

    public ReviewAddServiceModel setRating(String rating) {
        this.rating = rating;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public ReviewAddServiceModel setAuthor(String author) {
        this.author = author;
        return this;
    }
}
