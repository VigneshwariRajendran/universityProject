package com.univ.exception;
import java.util.Date;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler 
{
	 @ExceptionHandler(DuplicateUserMailIdException .class)
	    public ResponseEntity<?> duplicateUserMailIdException(DuplicateUserMailIdException exception, WebRequest request){
	        ErrorDetails errorDetails = 
	                new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
	        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	 
	 @ExceptionHandler(BadcredentialsException .class)
	    public ResponseEntity<?> badcredentialsException(BadcredentialsException exception, WebRequest request){
	        ErrorDetails errorDetails = 
	                new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
	        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	 
	
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request){
	        ErrorDetails errorDetails = 
	                new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
	        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

