package com.arthurlamberti.ecommerce.vo.address;

import com.arthurlamberti.ecommerce.enums.UserTypeEnum;

import java.time.LocalDateTime;

public record Address(
        String country,
        String state,
        String city,
        String street,
        String zipcode,
        String number,
        String complement,
        UserTypeEnum userType,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime deletedAt
) {
    public static Address from(CreateAddressRequest createAddressRequest) {
        return new Address(
                createAddressRequest.country(),
                createAddressRequest.state(),
                createAddressRequest.city(),
                createAddressRequest.street(),
                createAddressRequest.zipcode(),
                createAddressRequest.number(),
                createAddressRequest.complement(),
                createAddressRequest.userType(),
                LocalDateTime.now(),
                null,
                null
        );
    }

    public static Address newAddress(String country, String state, String city, String street, String zipcode, String number, String complement, UserTypeEnum userType) {
        return new Address(
                country, state, city, street, zipcode, number, complement, userType, LocalDateTime.now(), null, null
        );
    }
}
