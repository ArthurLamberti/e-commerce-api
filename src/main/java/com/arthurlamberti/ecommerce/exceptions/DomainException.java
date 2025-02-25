package com.arthurlamberti.ecommerce.exceptions;

import com.arthurlamberti.ecommerce.validators.Error;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

@Getter
public class DomainException extends NoStacktraceException {
    protected final List<com.arthurlamberti.ecommerce.validators.Error> errors;

    public DomainException(String aMessage, final List<com.arthurlamberti.ecommerce.validators.Error> erros) {
        super(aMessage);
        this.errors = erros;
    }

    public Optional<Error> getFirstError() {
        return Optional.of(errors.get(0));
    }
}
