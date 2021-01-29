package com.gabriel.querocomida.resources.exceptions;

import com.gabriel.querocomida.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandarError> entityNotFound(ResourceNotFoundException e,
																										 HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandarError standarError = new StandarError(Instant.now(), status.value(), "Resource not " +
				"found", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(standarError);
	}
}
