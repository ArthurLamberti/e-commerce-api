package com.arthurlamberti.ecommerce.vo.address;

import com.arthurlamberti.ecommerce.enums.UserTypeEnum;
import com.arthurlamberti.ecommerce.models.AddressJPAEntity;

import java.time.LocalDateTime;

public record Address(
        String country,
        String state,
        String city,
        String street,
        String zipcode,
        String numeral,
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
                createAddressRequest.numeral(),
                createAddressRequest.complement(),
                createAddressRequest.userType(),
                LocalDateTime.now(),
                null,
                null
        );
    }

    public AddressJPAEntity toEntity(String uuid) {
        return new AddressJPAEntity(
                uuid,
                this.country,
                this.state,
                this.city,
                this.street,
                this.zipcode,
                this.numeral,
                this.complement,
                this.deletedAt
        );
    }

    public static Address newAddress(String country, String state, String city, String street, String zipcode, String numeral, String complement, UserTypeEnum userType) {
        return new Address(
                country, state, city, street, zipcode, numeral, complement, userType, LocalDateTime.now(), null, null
        );
    }
}
