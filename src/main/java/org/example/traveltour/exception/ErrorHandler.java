package org.example.traveltour.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.example.traveltour.model.enums.ExceptionConstants.UNEXPECTED_EXCEPTION;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ErrorHandler {
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handle(Exception e) {
        return new ErrorResponse(UNEXPECTED_EXCEPTION.getCode(), UNEXPECTED_EXCEPTION.getMessage());
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler
    public ErrorResponse handle(NotFoundException ex) {
        return new ErrorResponse(ex.getCode(), ex.getMessage());
    }
    @ExceptionHandler(IllegalArgumentException.class)
   public ErrorResponse handle(IllegalArgumentException ex) {
        return new ErrorResponse(ex.getCode(),ex.getMessage());
   }
}
