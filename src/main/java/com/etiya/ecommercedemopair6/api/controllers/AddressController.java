package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.AddressService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.address.CreateAddressRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.CreateAddressResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.GetAddressResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.GetAllAddressResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@AllArgsConstructor
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/getAll")
    public List<GetAllAddressResponse> getAll() {
        return this.addressService.getAll();
    }

    @GetMapping("/getById")
    public GetAddressResponse getById(@RequestParam int id) {
        return addressService.getById(id);
    }

    @GetMapping("/getAllAddressByTitle")
    public List<GetAllAddressResponse> getAllAddressByTitle(String title){
        return  addressService.getAllAddressByTitle(title);
    }

    @GetMapping("/getAddress")
    public GetAddressResponse addressFind(@RequestParam int id ){
        return addressService.getByIdJPQLMethod(id);
    }
//    @GetMapping("/getAllCitiesByAddressId")
//    public Address getAllCitiesByAddressId(@RequestParam("id")int id){
//        return addressService.getAllCitiesByAddresId(id);
//
//    }

    @PostMapping("/add")
    public ResponseEntity<CreateAddressResponse> createAddress(@RequestBody @Valid CreateAddressRequest createAddressRequest){
        return new ResponseEntity<CreateAddressResponse>( addressService.addAddress(createAddressRequest), HttpStatus.CREATED);
    }

}
