package com.arthurlamberti.ecommerce.exceptions;

import com.arthurlamberti.ecommerce.validators.handler.Notification;

public class ValidationException extends RuntimeException {
    public ValidationException(String message, Notification notification) {
        super(message);
    }

    public ValidationException(String message) {
        super(message);
    }
}
