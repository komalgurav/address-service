package com.practice.service;

import com.practice.entity.Address;
import com.practice.repository.AddressRepository;
import com.practice.request.CreateAddressRequest;
import com.practice.response.AddressResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    Logger logger = LoggerFactory.getLogger(AddressService.class);
    @Autowired
    AddressRepository addressRepository;

    public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {
        Address address = new Address();
        address.setStreet(createAddressRequest.getStreet());
        address.setCity(createAddressRequest.getCity());
        addressRepository.save(address);

        return new AddressResponse(address);
    }

    public AddressResponse getById(long id) {
        logger.info("Getting address by id: {}", id);
        Address address = addressRepository.findById(id).orElse(null);
        return new AddressResponse(address);
    }
}
