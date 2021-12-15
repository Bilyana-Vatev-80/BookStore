package com.example.bookstore.model.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PastOrCurrentYearValidator.class)
public @interface PastOrCurrentYear {

    String message() default "Release year should be in the past or the current year";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
