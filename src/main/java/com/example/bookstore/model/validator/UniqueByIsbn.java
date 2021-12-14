package com.example.bookstore.model.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueByIsbnValidator.class)
public @interface UniqueByIsbn {

    String message() default "Book with this ISBN is already present in the Database";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
