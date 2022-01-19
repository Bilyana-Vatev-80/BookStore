package com.example.bookstore.repository;

import com.example.bookstore.model.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CartRepository extends JpaRepository<CartEntity,Long> {
    @Transactional
    void deleteAllByBookId(Long book_id);
}
