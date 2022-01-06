package com.example.bookstore.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "favorites")
public class WishlistItemEntity extends BaseEntity{

    @ManyToOne(optional = false)
    private BookEntity book;

    @ManyToOne(optional = false)
    private UserEntity userEntity;

    public WishlistItemEntity() {
    }

    public BookEntity getBook() {
        return book;
    }

    public WishlistItemEntity setBook(BookEntity book) {
        this.book = book;
        return this;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public WishlistItemEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }
}
