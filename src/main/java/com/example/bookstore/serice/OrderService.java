package com.example.bookstore.serice;

import com.example.bookstore.model.view.OrderViewModel;
import javassist.tools.rmi.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<OrderViewModel> findAllOrders();

    List<OrderViewModel> findAllOrdersByCustomer(String username);

    List<OrderViewModel> findLastFiveOrdersByCustomer(String username);

    Long createOrder(String username);

    Optional<OrderViewModel> findById(Long id);

    Boolean isOwner(String userName, Long id);
}
