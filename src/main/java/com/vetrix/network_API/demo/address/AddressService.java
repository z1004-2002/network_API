package com.vetrix.network_API.demo.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAddress(){
        return addressRepository.findAll();
    }

    public Optional<Address> getAddressById(UUID id){
        if(!addressRepository.existsById(id))
            throw new IllegalStateException("This address does not exists");

        return addressRepository.findById(id);
    }

    public Address addNewAddress(Address address){
        addressRepository.save(address);
        return address;
    }
    public Address updateAddress(UUID id, Address address){
        if(!addressRepository.existsById(id))
            throw new IllegalStateException("This address does not exists");
        addressRepository.findById(id).map(a ->{
            a.setCity(address.getCity());
            a.setState(address.getState());
            return addressRepository.save(a);
        });
        return address;
    }
    public void delete(UUID id){
        if(!addressRepository.existsById(id))
            throw new IllegalStateException("This address does not exists");
        addressRepository.deleteById(id);
    }
}
