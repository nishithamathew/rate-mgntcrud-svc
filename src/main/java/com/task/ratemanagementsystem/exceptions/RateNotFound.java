package com.task.ratemanagementsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RateNotFound extends Exception {
	private static final long serialVersionUID = 1L;

	public RateNotFound(String message) {
		super(message);
	}

}
