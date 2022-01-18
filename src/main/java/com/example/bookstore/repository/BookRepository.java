package com.example.bookstore.repository;

import com.example.bookstore.model.entity.BookEntity;
import com.example.bookstore.model.view.BookSummaryViewModel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {
    boolean existsByIsbn(String isbn);

    @EntityGraph(value = "bookEntity")
    List<BookEntity> findAllByActiveTrueAndAuthorIdOrderByAddedOnDesc(Long id);

    @EntityGraph(value = "bookEntity")
    List<BookEntity> findAllByActiveTrueOrderByAddedOnDesc();

    @EntityGraph(value = "bookEntity")
    List<BookEntity> findAllByActiveTrueOrderByTitleAscAddedOnDesc();

    @EntityGraph(value = "bookEntity")
    @Query("SELECT b FROM BookEntity b " +
            "WHERE b.isActive = true " +
            "ORDER BY b.author.firstName, b.author.lastName, b.addedOn DESC ")
    List<BookEntity> findAllByActiveTrueOrderByAuthor();

    @EntityGraph(value = "bookEntity")
    @Query("SELECT b FROM BookEntity  b " +
            "LEFT JOIN OrderItemEntity o ON b.id = o.book.id " +
            "WHERE b.isActive = true " +
            "GROUP BY b.id " +
            "ORDER BY COUNT(o.id) DESC, b.addedOn DESC ")
    List<BookEntity> findAllByActiveTrueOrderByBestSelling();

    @EntityGraph(value = "bookEntity")
    Optional<BookEntity> findByIdAndActiveTrue(Long id);

    boolean existsByPictureId(Long pictureId);
}
