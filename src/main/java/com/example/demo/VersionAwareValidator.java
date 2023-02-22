package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class VersionAwareValidator {

    @Autowired
    private ValidatorsFactory validatorsFactory;

    public void validate(ApiVersion apiVersion, PersonDto personDto) {
        Validator validator = validatorsFactory.resolveValidator(apiVersion);
        // perform javax validation manually
        Set<ConstraintViolation<PersonDto>> res = validator.validate(personDto);
        if (!res.isEmpty()) {
            throwError(res, null);
        }
        ApiVersion[] targetApiGroups = apiVersion.getTargetApiGroups();
        for (ApiVersion targetApiGroup : targetApiGroups) {
            res = validator.validate(personDto, targetApiGroup.getApiVersionGroup());
            if (!res.isEmpty()) {
                throwError(res, targetApiGroup);
            }
        }
    }

    private static void throwError(Set<ConstraintViolation<PersonDto>> res, ApiVersion apiVersion) {
        ConstraintViolation<PersonDto> violation = res.iterator().next();
        String message = violation.getPropertyPath() + ": " + violation.getMessage()
                + (apiVersion != null ? " ( in " + apiVersion.name() + ")" : "");
        throw new IllegalArgumentException(message);
    }
}
