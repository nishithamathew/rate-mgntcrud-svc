package com.task.ratemanagementsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.task.ratemanagementsystem.model.ErrorResponse;

@ControllerAdvice
public class RMSExceptionHandler {

	@ExceptionHandler(RateNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public final ResponseEntity<ErrorResponse> handleRateNotFound(RateNotFound rateNotFound) {
		return generateErrorResp(rateNotFound, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ServerException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public final ResponseEntity<ErrorResponse> handleInternalServerError(ServerException serverException) {
		return generateErrorResp(serverException, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ResponseEntity<ErrorResponse> generateErrorResp(Exception ex, HttpStatus httpStatus) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErroCode(httpStatus.value() + "");
		errorResponse.setErrorMessage(ex.getLocalizedMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, httpStatus);
	}

}
