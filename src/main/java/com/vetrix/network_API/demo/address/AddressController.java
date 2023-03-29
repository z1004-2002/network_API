package com.vetrix.network_API.demo.address;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/address")
@Tag(name = "Test Address")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAddress(){
        return addressService.getAddress();
    }

    @GetMapping("/{id}")
    public Optional<Address> getAddressById(@PathVariable UUID id){
        return addressService.getAddressById(id);
    }

    @PostMapping("/add")
    public Address addAddress(@RequestBody Address address){
        return addressService.addNewAddress(address);
    }

    @PutMapping("/update/{id}")
    public Address updateAddress(@PathVariable UUID id,@RequestBody Address address){
        return addressService.updateAddress(id, address);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable UUID id){
        addressService.delete(id);
        return "this address is delete";
    }
}
