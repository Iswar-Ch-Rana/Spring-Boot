package com.iswar.usercrud.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    // handle specific exceptions
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFound exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
                webRequest.getDescription(false), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    // handle global exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
                webRequest.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // handling custom validation error

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Error",
                exception.getBindingResult().getFieldError().getDefaultMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }

}
