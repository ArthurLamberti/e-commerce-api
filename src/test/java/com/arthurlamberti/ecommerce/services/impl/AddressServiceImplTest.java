package com.arthurlamberti.ecommerce.services.impl;

import com.arthurlamberti.ecommerce.UnitTest;
import com.arthurlamberti.ecommerce.exceptions.ValidationException;
import com.arthurlamberti.ecommerce.fixture.AddressFixture;
import com.arthurlamberti.ecommerce.models.AddressJPAEntity;
import com.arthurlamberti.ecommerce.repositories.AddressRepository;
import com.arthurlamberti.ecommerce.validators.AddressValidator;
import com.sun.security.auth.UserPrincipal;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AddressServiceImplTest extends UnitTest {

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private AddressValidator addressValidator;

    @InjectMocks
    private AddressServiceImpl addressService;

    @Captor
    private ArgumentCaptor<AddressJPAEntity> addressJPAEntityArgumentCaptor;

    @Override
    protected List<Object> getMocks() {
        return List.of();
    }

    @Test
    public void givenInvalidParams_whenCallsCreateAddress_thenThrowsException() {
        final var addressRequest = AddressFixture.createAddressRequest();

        doThrow(new ValidationException("Address invalid")).when(addressValidator).validateAddress(any());

        final var actualException = assertThrows(ValidationException.class,() -> addressService.createAddress(addressRequest, new UserPrincipal("")));

        assertNotNull(actualException);
        verify(addressRepository, never()).save(any());
    }

    @Test
    public void thenShouldSaveIt() {
        final var addressRequest = AddressFixture.createAddressRequest();

        doNothing().when(addressValidator).validateAddress(any());
        when(addressRepository.save(addressJPAEntityArgumentCaptor.capture())).thenAnswer(returnsFirstArg());

        addressService.createAddress(addressRequest, new UserPrincipal(""));
        final var actualCaptor = addressJPAEntityArgumentCaptor.getValue();

        assertNotNull(actualCaptor);
        assertEquals(addressRequest.country(), actualCaptor.getCountry());
        assertEquals(addressRequest.city(), actualCaptor.getCity());
        assertEquals(addressRequest.state(), actualCaptor.getState());
        assertEquals(addressRequest.street(), actualCaptor.getStreet());
        assertEquals(addressRequest.zipcode(), actualCaptor.getZipCode());
        assertEquals(addressRequest.numeral(), actualCaptor.getNumeral());
        assertEquals(addressRequest.complement(), actualCaptor.getComplement());
    }

}