package com.example.bookstore.model.binding;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ReviewAddBindingModel {

    private Long bookId;

    @NotBlank(message = "Please enter your name")
    private String nickname;

    private String title;

    private String textContent;

    @NotNull
    @Min(value = 1, message = "Please provide rating from 1 to 5")
    @Max(value = 5, message = "Please provide rating from 1 to 5")
    private Integer rating;

    public ReviewAddBindingModel() {
    }

    public Long getBookId() {
        return bookId;
    }

    public ReviewAddBindingModel setBookId(Long bookId) {
        this.bookId = bookId;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public ReviewAddBindingModel setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ReviewAddBindingModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public ReviewAddBindingModel setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public Integer getRating() {
        return rating;
    }

    public ReviewAddBindingModel setRating(Integer rating) {
        this.rating = rating;
        return this;
    }
}
