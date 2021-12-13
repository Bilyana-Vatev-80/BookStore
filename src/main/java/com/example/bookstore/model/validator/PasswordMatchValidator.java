package com.example.bookstore.model.validator;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordsMatch,Object> {
    private String password;
    private String confirmPassword;
    private String message;

    @Override
    public void initialize(PasswordsMatch constrainAnnotation){
        this.password = constrainAnnotation.password();
        this.confirmPassword = constrainAnnotation.confirmPassword();
        this.message = constrainAnnotation.message();
    }
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(value);

        Object passwordValue = beanWrapper.getPropertyValue(password);
        Object confirmPasswordValue = beanWrapper.getPropertyValue(confirmPassword);

        boolean valid;

        if(passwordValue == null){
            valid = confirmPasswordValue == null;
        } else {
            valid = passwordValue.equals(confirmPasswordValue);
        }

        if(!valid) {
            context
                    .buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(password)
                    .addConstraintViolation()
                    .buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(confirmPassword)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();;
        }
        return valid;
    }
}
