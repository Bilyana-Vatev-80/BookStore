package com.example.bookstore.model.entity;

import com.example.bookstore.model.entity.enums.LanguageEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
@NamedEntityGraph(
        name = "bookEntity",
        attributeNodes = {
                @NamedAttributeNode("picture"),
                @NamedAttributeNode("categories"),
                @NamedAttributeNode("publishingHouse"),
                @NamedAttributeNode("author"),
                @NamedAttributeNode("creator")
        }
)
@Entity
@Table(name = "books")
public class BookEntity extends BaseEntity{

    @Column(nullable = false,unique = true)
    private String isbn;
    @Column(nullable = false)
    private String title;
    @Lob
    private String description;
    @ManyToOne
    private PictureEntity picture;
    @Column(name = "added_on",nullable = false)
    private Instant addedOn;
    @Column(nullable = false)
    private Instant modified;
    @Column(nullable = false)
    private Boolean isActive;
    @Column(nullable = false)
    private Integer copies;
    @Column(nullable = false)
    private Integer releaseYear;
    @Column(nullable = false)
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LanguageEnum language;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<CategoryEntity> categories = new ArrayList<>();
    @ManyToOne(optional = false)
    private PublishingHouseEntity publishingHouse;
    @ManyToOne(optional = false)
    private AuthorEntity author;
    @ManyToOne(optional = false)
    private UserEntity creator;

    public BookEntity() {
    }

    public String getIsbn() {
        return isbn;
    }

    public BookEntity setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BookEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public PictureEntity getPicture() {
        return picture;
    }

    public BookEntity setPicture(PictureEntity picture) {
        this.picture = picture;
        return this;
    }

    public Instant getAddedOn() {
        return addedOn;
    }

    public BookEntity setAddedOn(Instant addedOn) {
        this.addedOn = addedOn;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public BookEntity setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public Boolean getActive() {
        return isActive;
    }

    public BookEntity setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public BookEntity setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public BookEntity setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BookEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LanguageEnum getLanguage() {
        return language;
    }

    public BookEntity setLanguage(LanguageEnum language) {
        this.language = language;
        return this;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public BookEntity setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
        return this;
    }

    public PublishingHouseEntity getPublishingHouse() {
        return publishingHouse;
    }

    public BookEntity setPublishingHouse(PublishingHouseEntity publishingHouse) {
        this.publishingHouse = publishingHouse;
        return this;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public BookEntity setAuthor(AuthorEntity author) {
        this.author = author;
        return this;
    }

    public UserEntity getCreator() {
        return creator;
    }

    public BookEntity setCreator(UserEntity creator) {
        this.creator = creator;
        return this;
    }

    @PrePersist
    public void onCreate(){
        this.setAddedOn(Instant.now());
        this.setModified(Instant.now());
    }

    @PreUpdate
    public void onUpdate(){
        this.setModified(Instant.now());
    }
}
