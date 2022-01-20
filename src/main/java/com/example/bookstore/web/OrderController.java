package com.example.bookstore.web;

import com.example.bookstore.serice.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all")
    public String allOrders(Model model){
        model.addAttribute("orders",orderService.findAllOrders());
        return "orders";
    }
}
