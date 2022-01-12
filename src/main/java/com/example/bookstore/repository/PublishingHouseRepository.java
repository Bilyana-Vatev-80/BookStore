package com.example.bookstore.repository;

import com.example.bookstore.model.entity.PublishingHouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublishingHouseRepository extends JpaRepository<PublishingHouseEntity,Long> {

    @Query("SELECT p.name FROM PublishingHouseEntity p " +
            "ORDER BY p.name")
    List<String> findAllPublishingHouseNames();

    Optional<PublishingHouseEntity> findByName(String name);
}
