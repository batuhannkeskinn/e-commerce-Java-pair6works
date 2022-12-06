package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.CountyService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.country.CreateCountryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.country.CreateCountryResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Country;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/countries")
public class CountryController {
    @Autowired
    private CountyService countyService;

    @GetMapping("/getById")
    public Country getById(@RequestParam int id){
        return countyService.getById(id);
    }

    @GetMapping("/getAll")
    public List<Country> getAll(){
        return countyService.getAllCountry();
    }


    @PostMapping("/add")

    public ResponseEntity<CreateCountryResponse>  createCountry(CreateCountryRequest createCountryRequest){
        return new ResponseEntity<>(countyService.createCountry(createCountryRequest), HttpStatus.CREATED);
    }
}
