package se.henrik.restserver.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import se.henrik.restserver.api.v1.model.ExceptionResponse;

/**
 * Exception Advice to handle exceptions thrown in Application
 */
@Slf4j
@RestControllerAdvice
class RestExceptionAdvice {
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(CarNotFoundException.class)
	ExceptionResponse handleCarNotFoundException(CarNotFoundException ex) {
		log.error(ex.getMessage(), ex);
		return new ExceptionResponse(ex.getMessage());
	}
}
