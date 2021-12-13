package com.example.bookstore.model.entity.enums;

import com.example.bookstore.util.DataUtils;

public enum LanguageEnum {
    BULGARIAN,
    ENGLISH,
    GERMAN;

    @Override
    public String toString(){
        return DataUtils.capitalizeEnum(name());
    }
}
