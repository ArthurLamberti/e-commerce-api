package com.arthurlamberti.ecommerce.services.impl;

import com.arthurlamberti.ecommerce.repositories.AddressRepository;
import com.arthurlamberti.ecommerce.services.AddressService;
import com.arthurlamberti.ecommerce.validators.AddressValidator;
import com.arthurlamberti.ecommerce.vo.address.Address;
import com.arthurlamberti.ecommerce.vo.address.CreateAddressRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressValidator addressValidator;
    private final AddressRepository addressRepository;

    public AddressServiceImpl(
            final AddressValidator addressValidator,
            final AddressRepository addressRepository
    ) {
        this.addressValidator = addressValidator;
        this.addressRepository = addressRepository;
    }

    @Override
    public void createAddress(@Valid CreateAddressRequest request, Principal principal) {
        final var address = Address.from(request);
        addressValidator.validateAddress(address);

        final var addressJpa = address.toEntity(UUID.randomUUID().toString().toLowerCase().replace("-", ""));
        this.addressRepository.save(addressJpa);
    }
}
