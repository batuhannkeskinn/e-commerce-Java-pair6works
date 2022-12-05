package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.AddressService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.address.CreateAddressRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.CreateAddressResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@AllArgsConstructor
public class AddressController {
    private AddressService addressService;

    @GetMapping("/getAll")
    public List<Address> getAll() {
        return this.addressService.getAll();
    }

    @GetMapping("/getById")
    public Address getById(@RequestParam int id) {
        return addressService.getById(id);
    }

    @GetMapping("/getAllAddressByTitle")
    public List<Address> getAllAddressByTitle(String title){
        return  addressService.getAllAddressByTitle(title);
    }

    @GetMapping("/getAddress")
    public Address addressFind(@RequestParam int id ){
        return addressService.addressTitle(id);
    }
//    @GetMapping("/getAllCitiesByAddressId")
//    public Address getAllCitiesByAddressId(@RequestParam("id")int id){
//        return addressService.getAllCitiesByAddresId(id);
//
//    }

    @PostMapping("/add")
    public ResponseEntity<CreateAddressResponse> createAddress(@RequestBody CreateAddressRequest createAddressRequest){
        return new ResponseEntity<CreateAddressResponse>( addressService.addAddress(createAddressRequest), HttpStatus.CREATED);
    }

}
