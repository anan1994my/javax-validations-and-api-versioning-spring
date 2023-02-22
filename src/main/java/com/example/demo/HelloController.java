package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

	@Autowired
	private VersionAwareValidator versionAwareValidator;

    @PostMapping("/hello")
	public Object post(@RequestBody PersonDto personDto,
					   @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType) {
		ApiVersion apiVersion = ApiVersion.fromHeader(contentType);
		versionAwareValidator.validate(apiVersion, personDto);
		return personDto;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	public ErrorDto handleExceptions(IllegalArgumentException e) {
		return new ErrorDto(e.getMessage());
	}
}
