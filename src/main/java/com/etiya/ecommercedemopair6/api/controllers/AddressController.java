package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.AddressService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.address.CreateAddressRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.CreateAddressResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.GetAddressResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.GetAllAddressResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "addresses")
@AllArgsConstructor
public class AddressController {
    @Autowired
    private AddressService addressService;


    @GetMapping("/getAll")
    public  ResponseEntity<DataResult<List<GetAllAddressResponse>>>getAll() {
        return new ResponseEntity<DataResult<List<GetAllAddressResponse>>>(addressService.getAll(),HttpStatus.OK) ;
    }

    @GetMapping("/getById")
    public ResponseEntity<DataResult<GetAddressResponse >>getById(@RequestParam int id) {
        return  new ResponseEntity<DataResult<GetAddressResponse >>(addressService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/getAllAddressByTitle")
    public  ResponseEntity<DataResult<List<GetAllAddressResponse>>> getAllAddressByTitle(String title) {
        return new ResponseEntity<DataResult<List<GetAllAddressResponse>>>(addressService.getAllAddressByTitle(title),HttpStatus.OK);
    }

    @GetMapping("/getAddress/")
    public ResponseEntity<DataResult<GetAddressResponse>> addressFind(@RequestParam int id) {
        return new ResponseEntity<DataResult<GetAddressResponse>>(addressService.getByIdJPQLMethod(id),HttpStatus.OK);
    }
//    @GetMapping("/getAllCitiesByAddressId")
//    public Address getAllCitiesByAddressId(@RequestParam("id")int id){
//        return addressService.getAllCitiesByAddresId(id);
//    }

    @PostMapping("/add")
    public ResponseEntity<Result> createAddress(@RequestBody @Valid CreateAddressRequest createAddressRequest) {
        return new ResponseEntity<Result>(addressService.addAddress(createAddressRequest), HttpStatus.CREATED);
    }

    @GetMapping("getAllAddressByCityName")
    public List<Address> findAddressByCityByCityName(@RequestParam("cityName") String cityName){
        return addressService.findAddressByCityByCityName(cityName);
    }
}
