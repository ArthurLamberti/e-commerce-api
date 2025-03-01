package com.arthurlamberti.ecommerce.validators;

import com.arthurlamberti.ecommerce.exceptions.ValidationException;
import com.arthurlamberti.ecommerce.validators.handler.Notification;
import com.arthurlamberti.ecommerce.vo.address.Address;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class AddressValidator {

    public void validateAddress(Address address) {
        final var notification = Notification.create();
        if (isNull(address)) {
            throw new ValidationException("Address cannot be null");
        }

        if (isNull(address.country()) || address.country().isBlank()) {
            notification.append(new Error("'country' cannot be null or empty"));
        }

        if (isNull(address.city()) || address.city().isBlank()) {
            notification.append(new Error("'city' cannot be null or empty"));
        }

        if (isNull(address.state()) || address.state().isBlank()) {
            notification.append(new Error("'state' cannot be null or empty"));
        }

        if (isNull(address.street()) || address.street().isBlank()) {
            notification.append(new Error("'street' cannot be null or empty"));
        }

        if (isNull(address.zipcode()) || address.zipcode().isBlank()) {
            notification.append(new Error("'zipcode' cannot be null or empty"));
        }

        if (isNull(address.numeral()) || address.numeral().isBlank()) {
            notification.append(new Error("'numeral' cannot be null or empty"));
        }

        if (isNull(address.userType())) {
            notification.append(new Error("'userType' cannot be null"));
        }

        if (notification.hasError()) {
            throw new ValidationException("Address invalid", notification);
        }
    }

}
