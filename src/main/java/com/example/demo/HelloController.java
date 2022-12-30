package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Set;
import java.util.regex.Pattern;

@RestController
public class HelloController {

	@Autowired
	private Validator validator;

    @PostMapping("/hello")
	public Object post(@RequestBody PersonDto personDto,
					   @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType) {
		ApiVersion apiVersion = ApiVersion.fromHeader(contentType);
		System.out.println("Api version: " + apiVersion);
		Set<ConstraintViolation<PersonDto>> res = validator.validate(personDto);
		System.out.println("Violations count: " + res.size());
		if (!res.isEmpty()) {
			ConstraintViolation<PersonDto> violation = res.iterator().next();
			return new ErrorDto(violation.getPropertyPath() + ": " + violation.getMessage());
		}
		return personDto;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorDto handleExceptions(MethodArgumentNotValidException e) {
		return new ErrorDto(e.getMessage());
	}
}
