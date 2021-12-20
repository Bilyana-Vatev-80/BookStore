package com.example.bookstore.model.view;

public class RequestsHouseViewModel {

    private Long id;
    private String name;
    private String description;
    private String imageUrl;

    public RequestsHouseViewModel() {
    }

    public Long getId() {
        return id;
    }

    public RequestsHouseViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RequestsHouseViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RequestsHouseViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public RequestsHouseViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
