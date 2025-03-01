package com.arthurlamberti.ecommerce.exceptions;

import com.arthurlamberti.ecommerce.validators.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<?> handleDomainException(final ValidationException ex) {
        return ResponseEntity.unprocessableEntity().body(ApiError.from(ex));
    }

    public record ApiError(String message, List<Error> errors) {
        static ApiError from(final ValidationException ex) {
            return new ApiError(ex.getMessage(), ex.getErrors());
        }
    }
}
