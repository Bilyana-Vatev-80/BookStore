package com.example.bookstore.util;

import com.example.bookstore.model.entity.CategoryEntity;

import java.util.List;
import java.util.stream.Collectors;

public class DataUtils {

    public static List<String> getCategories(List<CategoryEntity> categoryEntities){
        return categoryEntities
                .stream()
                .map(categoryEntity -> categoryEntity.getCategory().name())
                .map(s -> s.charAt(0) + s.substring(1).toLowerCase().replaceAll("_", " "))
                .collect(Collectors.toList());
    }

    public static String getFullName(String firstname,String lastname){
        return firstname + " " + lastname;
    }

    public static String capitalizeEnum(String name){
        return name.charAt(0) + name.substring(1).toLowerCase()
                .replaceAll("_", " ");
    }
}
