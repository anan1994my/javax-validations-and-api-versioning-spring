package com.example.demo.validation;

import com.example.demo.ApiVersion;
import org.slf4j.MDC;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullVersionedValidator implements ConstraintValidator<NotNullVersioned, Object> {

    private ApiVersion requestVersion;
    private ApiVersion addedInVersion;

    @Override
    public void initialize(NotNullVersioned constraintAnnotation) {
        String version = MDC.get("version");
        this.requestVersion = ApiVersion.valueOf(version);
        this.addedInVersion = constraintAnnotation.addedInVersion();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o != null) return true;
        // skip validation in old version
        if (requestVersion.ordinal() < addedInVersion.ordinal()) return true;
        return false;
    }
}
