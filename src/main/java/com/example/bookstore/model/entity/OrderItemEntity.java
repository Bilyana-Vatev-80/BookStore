package com.example.bookstore.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItemEntity extends BaseEntity{

    @ManyToOne
    private BookEntity book;
    @ManyToOne
    private OrderEntity order;
    @Column(nullable = false)
    private Integer quantity;

    public OrderItemEntity() {
    }

    public BookEntity getBook() {
        return book;
    }

    public OrderItemEntity setBook(BookEntity book) {
        this.book = book;
        return this;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public OrderItemEntity setOrder(OrderEntity order) {
        this.order = order;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderItemEntity setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
