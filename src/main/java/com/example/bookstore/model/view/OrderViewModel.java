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

}
