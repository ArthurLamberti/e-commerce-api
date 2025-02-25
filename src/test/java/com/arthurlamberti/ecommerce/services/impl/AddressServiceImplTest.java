package com.arthurlamberti.ecommerce.services.impl;

import com.arthurlamberti.ecommerce.UnitTest;
import com.arthurlamberti.ecommerce.enums.UserTypeEnum;
import com.arthurlamberti.ecommerce.repositories.AddressRepository;
import com.arthurlamberti.ecommerce.vo.address.CreateAddressRequest;
import com.sun.security.auth.UserPrincipal;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

class AddressServiceImplTest extends UnitTest {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressServiceImpl addressService;

    @Override
    protected List<Object> getMocks() {
        return List.of();
    }

    @ParameterizedTest
    @CsvSource("""
            brazil,rs,mgo,street,92103020,123,,SELLER
            """)
    public void givenInvalidParams_whenCallsCreateAddress_thenThrowsException(
            String country,
            String state,
            String city,
            String street,
            String zipcode,
            String number,
            String complement,
            UserTypeEnum userType
    ) {
        final var addressRequest = new CreateAddressRequest(country, state, city, street, zipcode, number, complement, userType);
        addressService.createAddress(addressRequest, new UserPrincipal(""));
    }

}