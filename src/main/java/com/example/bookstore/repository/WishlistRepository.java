package com.example.bookstore.repository;

import com.example.bookstore.model.entity.WishlistItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface WishlistRepository extends JpaRepository<WishlistItemEntity,Long> {

    @Transactional
    void deleteAllByBookId(Long book_id);
}
