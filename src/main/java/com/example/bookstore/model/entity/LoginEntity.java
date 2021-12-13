package com.example.bookstore.model.entity;

import com.example.bookstore.model.entity.enums.OrderStatusEnum;


import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "logins")
public class LoginEntity extends BaseEntity{

    @ManyToOne
    private OrderEntity order;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatusEnum status;
    @Column(nullable = false)
    private Instant changeTime;

    public LoginEntity() {
    }

    public OrderEntity getOrder() {
        return order;
    }

    public LoginEntity setOrder(OrderEntity order) {
        this.order = order;
        return this;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public LoginEntity setStatus(OrderStatusEnum status) {
        this.status = status;
        return this;
    }

    public Instant getChangeTime() {
        return changeTime;
    }

    public LoginEntity setChangeTime(Instant changeTime) {
        this.changeTime = changeTime;
        return this;
    }
}
