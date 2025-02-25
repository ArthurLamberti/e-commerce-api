package com.arthurlamberti.ecommerce.services.impl;

import com.arthurlamberti.ecommerce.services.AddressService;
import com.arthurlamberti.ecommerce.validators.AddressValidator;
import com.arthurlamberti.ecommerce.vo.address.Address;
import com.arthurlamberti.ecommerce.vo.address.CreateAddressRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AddressServiceImpl implements AddressService {

    private AddressValidator addressValidator;

    @Override
    public void createAddress(@Valid CreateAddressRequest request, Principal principal) {
        final var address = Address.from(request);
        addressValidator.validateAddress(address);
        System.out.println(request.city());
    }
}
