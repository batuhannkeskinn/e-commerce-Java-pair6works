package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.CountyService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.country.CreateCountryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.country.CreateCountryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.country.GetAllCountryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.country.GetCountryResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(Paths.apiPrefix+"countries")
public class CountryController {
    @Autowired
    private CountyService countyService;

    @GetMapping("/getById")
    public ResponseEntity<DataResult<GetCountryResponse >>getById(@RequestParam int id){
        return new ResponseEntity<>(countyService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<DataResult< List<GetAllCountryResponse>>> getAll(){
        return  new ResponseEntity<>(countyService.getAllCountry(),HttpStatus.OK);
    }


    @PostMapping("/add")

    public ResponseEntity<Result>  createCountry(CreateCountryRequest createCountryRequest){
        return new ResponseEntity<>(countyService.createCountry(createCountryRequest), HttpStatus.CREATED);
    }
}
