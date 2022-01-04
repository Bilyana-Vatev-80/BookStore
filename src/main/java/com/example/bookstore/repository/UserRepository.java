package com.example.bookstore.repository;

import com.example.bookstore.model.entity.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @EntityGraph(value = "roles")
    Optional<UserEntity> findByUsernameIgnoreCase(String username);

    @EntityGraph(value = "roles")
    Optional<UserEntity> findByUsername(String username);

    List<String> findAllByUsername();
}
