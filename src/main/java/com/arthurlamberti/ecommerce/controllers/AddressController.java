package com.arthurlamberti.ecommerce.controllers;

import com.arthurlamberti.ecommerce.services.AddressService;
import com.arthurlamberti.ecommerce.vo.address.Address;
import com.arthurlamberti.ecommerce.vo.address.CreateAddressRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.security.Principal;

@RequestMapping("addresses")
@Tag(name = "Address")
@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(final AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<?> createAddress(
            @RequestBody @Valid CreateAddressRequest createAddressRequest,
            Principal principal
    ) {
        addressService.createAddress(createAddressRequest, principal);
        return ResponseEntity.created(URI.create("/addresses")).build();
    }
}
