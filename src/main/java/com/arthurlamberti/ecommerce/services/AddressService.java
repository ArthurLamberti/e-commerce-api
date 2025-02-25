package com.arthurlamberti.ecommerce.services;

import com.arthurlamberti.ecommerce.vo.address.CreateAddressRequest;
import jakarta.validation.Valid;

import java.security.Principal;

public interface AddressService {

    void createAddress(@Valid CreateAddressRequest request, Principal principal);

}
