package com.example.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullVersionedValidator implements ConstraintValidator<NotNullVersioned, Object> {
    @Override
    public void initialize(NotNullVersioned constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return o != null;
    }
}
