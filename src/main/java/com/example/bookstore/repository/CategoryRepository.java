package com.example.bookstore.repository;

import com.example.bookstore.model.entity.CategoryEntity;
import com.example.bookstore.model.entity.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

    Optional<CategoryEntity> findByCategory(CategoryEnum category);
}
