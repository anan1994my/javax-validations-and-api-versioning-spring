package com.example.demo.validation;

import com.example.demo.ApiVersion;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullVersionedValidator implements ConstraintValidator<NotNullVersioned, Object> {

    private ApiVersion addedInVersion;
    private ApiVersion removedInVersion;

    @Override
    public void initialize(NotNullVersioned constraintAnnotation) {
        this.addedInVersion = constraintAnnotation.addedInVersion();
        this.removedInVersion = constraintAnnotation.removedInVersion();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o != null) return true;
        if ( constraintValidatorContext instanceof HibernateConstraintValidatorContext) {
            final String payload = constraintValidatorContext
                    .unwrap(HibernateConstraintValidatorContext.class)
                    .getConstraintValidatorPayload(String.class);
            ApiVersion requestApiVersion = ApiVersion.valueOf(payload);

            // skip validation in old version
            if (requestApiVersion.ordinal() < addedInVersion.ordinal()){
                return true;
            }
            // skip validation after version
            if (requestApiVersion.ordinal() >= removedInVersion.ordinal()) {
                return true;
            }
        }
        return false;
    }
}
