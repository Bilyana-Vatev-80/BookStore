package com.example.bookstore.model.entity.enums;


import com.example.bookstore.util.DataUtils;

public enum CategoryEnum {
    FICTION,
    CRIME_AND_THRILLER,
    ROMANCE,
    FANTASY,
    SCIENCE_FICTION,
    SCIENCE,
    CLASSICS,
    CHILDREN,
    HISTORY,
    ART,
    DYSTOPIA,
    HORROR,
    POETRY;

    @Override
    public String toString(){
        return DataUtils.capitalizeEnum(name());
    }
}
