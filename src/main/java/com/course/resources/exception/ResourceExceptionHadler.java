package com.course.resources.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.course.service.exception.DataBaseException;
import com.course.service.exception.ObjectNotFound;

@ControllerAdvice
public class ResourceExceptionHadler {

	@ExceptionHandler(ObjectNotFound.class)
	public ResponseEntity<StandarError> resourceNotFound(ObjectNotFound e, HttpServletRequest request){
		String erro = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandarError standarError = new StandarError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(standarError);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandarError> dataBaseException(DataBaseException e, HttpServletRequest request){
		String erro = "Database Error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandarError standarError = new StandarError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(standarError);
	}
}
