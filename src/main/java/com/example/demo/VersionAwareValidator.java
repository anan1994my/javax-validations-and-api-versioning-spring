package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class VersionAwareValidator {

    @Autowired
    private Validator validator;

    public void validate(ApiVersion apiVersion, PersonDto personDto) {
//        MDC.put("version", apiVersion.name());
        Set<ConstraintViolation<PersonDto>> res = validator.validate(personDto);
        if (!res.isEmpty()) {
            ConstraintViolation<PersonDto> violation = res.iterator().next();
            String message = violation.getPropertyPath() + ": " + violation.getMessage();
            throw new IllegalArgumentException(message);
        }
        ApiVersion[] targetApiGroups = apiVersion.getTargetApiGroups();
        for (ApiVersion targetApiGroup : targetApiGroups) {
            res = validator.validate(personDto, targetApiGroup.getApiVersionGroup());
            if (!res.isEmpty()) {
                ConstraintViolation<PersonDto> violation = res.iterator().next();
                String message = violation.getPropertyPath() + ": " + violation.getMessage();
                throw new IllegalArgumentException(message);
            }
        }


    }
}
