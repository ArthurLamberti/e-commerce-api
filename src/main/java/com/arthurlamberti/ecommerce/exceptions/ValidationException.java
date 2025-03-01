package com.arthurlamberti.ecommerce.exceptions;

import com.arthurlamberti.ecommerce.validators.Error;
import com.arthurlamberti.ecommerce.validators.handler.Notification;

import java.util.ArrayList;
import java.util.List;

public class ValidationException extends RuntimeException {
    protected final List<Error> errors;

    public ValidationException(String message, Notification notification) {
        super(message);
        this.errors = notification.getErrors();
    }

    public ValidationException(String message) {
        super(message);
        this.errors = new ArrayList<>();
    }

    public Error getFirstError() {
        return errors.getFirst();
    }

    public List<Error> getErrors() {
        return this.errors;
    }
}
