package com.example.bookstore.serice;

import com.example.bookstore.model.view.OrderViewModel;
import javassist.tools.rmi.ObjectNotFoundException;

import java.util.List;

public interface OrderService {

    List<OrderViewModel> findAllOrders();

    List<OrderViewModel> findAllOrdersByCustomer(String username);

    List<OrderViewModel> findLastFiveOrdersByCustomer(String username);

    Long createOrder(String username) throws IllegalAccessException, ObjectNotFoundException;
}
