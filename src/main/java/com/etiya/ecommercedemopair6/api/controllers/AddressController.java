package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.AddressService;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


}
