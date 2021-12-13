package com.example.bookstore.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class AuthorEntity extends BaseEntity{

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Lob
    private String description;
    @ManyToOne
    private PictureEntity picture;

    public AuthorEntity() {
    }

    public String getFirstName() {
        return firstName;
    }

    public AuthorEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AuthorEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AuthorEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public PictureEntity getPicture() {
        return picture;
    }

    public AuthorEntity setPicture(PictureEntity picture) {
        this.picture = picture;
        return this;
    }
}
