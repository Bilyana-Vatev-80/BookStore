package com.example.bookstore.repository;

import com.example.bookstore.model.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {

    List<OrderEntity> findAllByOrderTimeDesc();

    List<OrderEntity> findAllByCustomerUsernameOrderByOrderTimeDesc(String customer_username);

    List<OrderEntity> findTop5ByCustomerUsernameOrderByOrderTimeDesc(String customer_username);
}
