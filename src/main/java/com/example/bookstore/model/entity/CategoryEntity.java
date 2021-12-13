package com.example.bookstore.model.entity;

import com.example.bookstore.model.entity.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,unique = true)
    private CategoryEnum category;

    public CategoryEntity() {
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public CategoryEntity setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }
}
