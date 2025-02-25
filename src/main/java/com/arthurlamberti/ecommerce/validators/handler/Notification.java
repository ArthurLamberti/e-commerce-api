package com.arthurlamberti.ecommerce.validators.handler;

import com.arthurlamberti.ecommerce.validators.Error;

import java.util.ArrayList;
import java.util.List;

public class Notification {

    private final List<Error> errors;

    private Notification(List<Error> errors) {
        this.errors = errors;
    }

    public static Notification create() {
        return new Notification(new ArrayList<>());
    }

    public Notification append(final Error anError) {
        this.errors.add(anError);
        return this;
    }

    public Notification append(Notification aHandler) {
        this.errors.addAll(aHandler.getErrors());
        return this;
    }

    public List<Error> getErrors() {
        return this.errors;
    }

    public boolean hasError() {
        return !this.errors.isEmpty();
    }
}
