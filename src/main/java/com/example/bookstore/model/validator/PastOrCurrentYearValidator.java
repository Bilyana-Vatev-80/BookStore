package com.example.bookstore.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;

public class PastOrCurrentYearValidator implements ConstraintValidator<PastOrCurrentYear,Integer> {

    private Integer currentYear;

    @Override
    public void initialize(PastOrCurrentYear constraintAnnotation) {
       this.currentYear = Calendar.getInstance().get(Calendar.YEAR);
    }

    @Override
    public boolean isValid(Integer year, ConstraintValidatorContext context) {
        if(year == null){
            return false;
        }
        return year <= this.currentYear;
    }
}
