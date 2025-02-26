package com.arthurlamberti.ecommerce.validators;

import com.arthurlamberti.ecommerce.UnitTest;
import com.arthurlamberti.ecommerce.enums.UserTypeEnum;
import com.arthurlamberti.ecommerce.exceptions.ValidationException;
import com.arthurlamberti.ecommerce.vo.address.Address;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;

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
    @CsvSource({
            ",state,city,street,04123,123,,SELLER,'country' cannot be null or empty",
            "country,,city,street,04123,123,,SELLER,'state' cannot be null or empty",
            "country,state,,street,04123,123,,SELLER,'city' cannot be null or empty",
            "country,state,city,,04123,123,,SELLER,'street' cannot be null or empty",
            "country,state,city,street,,123,,SELLER,'zipcode' cannot be null or empty",
            "country,state,city,street,04123,,,SELLER,'number' cannot be null or empty",
            "country,state,city,street,04123,123,,,'userType' cannot be null",
            "' ',state,city,street,04123,123,,SELLER,'country' cannot be null or empty",
            "country,'  ',city,street,04123,123,,SELLER,'state' cannot be null or empty",
            "country,state,' ',street,04123,123,,SELLER,'city' cannot be null or empty",
            "country,state,city,' ',04123,123,,SELLER,'street' cannot be null or empty",
            "country,state,city,street,' ',123,,SELLER,'zipcode' cannot be null or empty",
            "country,state,city,street,04123,' ',,SELLER,'number' cannot be null or empty"
    })
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
        final var actualError = assertThrows(ValidationException.class, () -> addressValidator.validateAddress(address));
        assertNotNull(address);
        assertEquals(errorMessage, actualError.getFirstError().message());
    }
}