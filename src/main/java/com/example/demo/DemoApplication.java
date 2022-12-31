package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.validation.ConstraintValidatorFactory;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	public Validator myValidator() {
//		ValidatorFactory validatorFactory = Validation.byDefaultProvider().configure().buildValidatorFactory();
//		ConstraintValidatorFactory constraintValidatorFactory = validatorFactory.getConstraintValidatorFactory();
//        NotNullVersionedValidator nullVersionedValidator = constraintValidatorFactory.getInstance(NotNullVersionedValidator.class);
//		Validator validator = validatorFactory.getValidator();
//		return validator;
//	}

}
