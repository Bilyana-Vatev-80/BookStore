package com.example.bookstore.model.entity;

import com.example.bookstore.model.entity.enums.UserRoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRoleEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,unique = true)
    private UserRoleEnum role;

    public UserRoleEntity() {
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public UserRoleEntity setRole(UserRoleEnum role) {
        this.role = role;
        return this;
    }
}
