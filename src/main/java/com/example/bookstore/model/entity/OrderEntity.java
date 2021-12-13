package com.example.bookstore.model.entity;

import com.example.bookstore.model.entity.enums.OrderStatusEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity{

    @Column(nullable = false)
    private LocalDateTime orderTime;
    @Column(nullable = false)
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status;
    @ManyToOne
    private UserEntity customer;

    public OrderEntity() {
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderEntity setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public OrderEntity setStatus(OrderStatusEnum status) {
        this.status = status;
        return this;
    }

    public UserEntity getCustomer() {
        return customer;
    }

    public OrderEntity setCustomer(UserEntity customer) {
        this.customer = customer;
        return this;
    }
}
