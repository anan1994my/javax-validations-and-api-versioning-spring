package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HelloController {
    @PostMapping("/hello")
	public PersonDto post(@RequestBody @Valid PersonDto personDto) {
		return personDto;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorDto handleExceptions(MethodArgumentNotValidException e) {
		return new ErrorDto(e.getMessage());
	}
}
