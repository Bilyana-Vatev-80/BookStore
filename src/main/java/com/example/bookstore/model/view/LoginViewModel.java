package com.example.bookstore.model.view;

import com.example.bookstore.model.entity.enums.OrderStatusEnum;

import java.time.ZonedDateTime;

public class LoginViewModel {

    private OrderStatusEnum status;
    private ZonedDateTime changeTime;

    public LoginViewModel() {
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public LoginViewModel setStatus(OrderStatusEnum status) {
        this.status = status;
        return this;
    }

    public ZonedDateTime getChangeTime() {
        return changeTime;
    }

    public LoginViewModel setChangeTime(ZonedDateTime changeTime) {
        this.changeTime = changeTime;
        return this;
    }
}
