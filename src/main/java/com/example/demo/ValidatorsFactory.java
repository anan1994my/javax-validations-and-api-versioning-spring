package com.example.demo;

import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashMap;
import java.util.Map;

@Component
public class ValidatorsFactory implements InitializingBean {

    private Map<ApiVersion, Validator> validatorMap = new HashMap<>();

    public Validator resolveValidator(ApiVersion apiVersion) {
        return validatorMap.get(apiVersion);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .buildValidatorFactory();
        for (ApiVersion apiVersion : ApiVersion.values()) {
            Validator validator = validatorFactory.unwrap(HibernateValidatorFactory.class)
                    .usingContext()
                    .constraintValidatorPayload(apiVersion.name())
                    .getValidator();
            validatorMap.put(apiVersion, validator);
        }
    }
}
