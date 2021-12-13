package com.example.bookstore.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "publishing_houses")
public class PublishingHouseEntity extends BaseEntity{
    @Column(nullable = false, unique = true)
    private String name;
    @Lob
    private String description;
    @Lob
    private String imageUrl;

    public PublishingHouseEntity() {
    }

    public String getName() {
        return name;
    }

    public PublishingHouseEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PublishingHouseEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public PublishingHouseEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
