package com.example.bookstore.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carts")
public class CartEntity extends BaseEntity{

    @ManyToOne(optional = false)
    private BookEntity book;
    @ManyToOne(optional = false)
    private UserEntity customer;
    @Column(nullable = false)
    private Integer quantity;

    public CartEntity() {
    }

    public BookEntity getBook() {
        return book;
    }

    public CartEntity setBook(BookEntity book) {
        this.book = book;
        return this;
    }

    public UserEntity getCustomer() {
        return customer;
    }

    public CartEntity setCustomer(UserEntity customer) {
        this.customer = customer;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public CartEntity setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
