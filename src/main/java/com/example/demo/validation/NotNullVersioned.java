package com.example.demo.validation;

import com.example.demo.ApiVersion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(NotNullVersioned.List.class)
@Constraint(
        validatedBy = {NotNullVersionedValidator.class}
)
public @interface NotNullVersioned {
    String message() default "should be not null starting from version";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    ApiVersion addedInVersion();

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        NotNullVersioned[] value();
    }
}

