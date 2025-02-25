package com.arthurlamberti.ecommerce.validators;

import com.arthurlamberti.ecommerce.UnitTest;
import com.arthurlamberti.ecommerce.enums.UserTypeEnum;
import com.arthurlamberti.ecommerce.vo.address.Address;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddressValidatorTest extends UnitTest {

    @InjectMocks
    private AddressValidator addressValidator;

    @Override
    protected List<Object> getMocks() {
        return List.of();
    }


    @ParameterizedTest
    @CsvSource("""
            ,rs,mgo,street,92103020,123,,SELLER,'country' cannot be null or empty
            """)
    public void givenInvalidParams_whenCallsCreateAddress_thenThrowsException(
            String country,
            String state,
            String city,
            String street,
            String zipcode,
            String number,
            String complement,
            UserTypeEnum userType,
            String errorMessage
    ) {
        final var address = Address.newAddress(country, state, city, street, zipcode, number, complement, userType);
        addressValidator.validateAddress(address);
    }
}