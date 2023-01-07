package com.gerimedica.medica.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceExceptions {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> userNotFound(ProductNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        errorResponse.setErrorMessage(exception.getErrorMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler(DateFomatException.class)
    public ResponseEntity<ErrorResponse> dateFormatException(DateFomatException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        errorResponse.setErrorMessage(exception.getErrorMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.PRECONDITION_FAILED);
    }
}
