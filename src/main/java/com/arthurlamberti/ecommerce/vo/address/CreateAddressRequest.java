package com.arthurlamberti.ecommerce.vo.address;

import com.arthurlamberti.ecommerce.enums.UserTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAddressRequest(

        @NotBlank
        String country,

        @NotBlank
        String state,

        @NotBlank
        String city,

        @NotBlank
        String street,

        @NotBlank
        String zipcode,

        @NotBlank
        String numeral,

        String complement,

        @NotNull
        UserTypeEnum userType
) {
}
