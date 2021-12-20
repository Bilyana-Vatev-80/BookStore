package com.example.bookstore.model.view;

public class PublishingHouseViewModel {

    private Long id;
    private String name;
    private String description;
    private String imageUrl;

    public PublishingHouseViewModel() {
    }

    public Long getId() {
        return id;
    }

    public PublishingHouseViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PublishingHouseViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PublishingHouseViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public PublishingHouseViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
