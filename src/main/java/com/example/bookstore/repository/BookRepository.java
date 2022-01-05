package com.example.bookstore.repository;

import com.example.bookstore.model.entity.BookEntity;
import com.example.bookstore.model.view.BookSummaryViewModel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {
    boolean existsByIsbn(String isbn);

    @EntityGraph(value = "bookEntity")
    List<BookEntity> findAllByActiveTrueAndAuthorIdOrderByAddedOnDesc(Long id);
}
