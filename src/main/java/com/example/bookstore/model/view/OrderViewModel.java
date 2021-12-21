package com.example.bookstore.model.view;

import com.example.bookstore.model.entity.enums.OrderStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderViewModel {

    private Long id;
    private LocalDateTime orderTime;
    private BigDecimal price;
    private OrderStatusEnum status;
    private String customerFullName;
    private String customerAddress;
    private List<OrderItemViewModel> orderedBooks;

    public OrderViewModel() {
    }

    public Long getId() {
        return id;
    }

    public OrderViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderViewModel setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public OrderViewModel setStatus(OrderStatusEnum status) {
        this.status = status;
        return this;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public OrderViewModel setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
        return this;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public OrderViewModel setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
        return this;
    }

    public List<OrderItemViewModel> getOrderedBooks() {
        return orderedBooks;
    }

    public OrderViewModel setOrderedBooks(List<OrderItemViewModel> orderedBooks) {
        this.orderedBooks = orderedBooks;
        return this;
    }
}
