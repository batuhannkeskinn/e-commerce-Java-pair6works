package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.CityService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.city.CreateCityRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.CreateCityResponse;
import com.etiya.ecommercedemopair6.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/getAll")
    public List<City> getAll(){
        return cityService.getAll();
    }

    @GetMapping("/getById")
    public City getById(@RequestParam int id){
        City response = cityService.getById(id);
        return response;
    }

    @PostMapping("/add")
    public ResponseEntity<CreateCityResponse> createCity(CreateCityRequest createCityRequest){
        return new ResponseEntity<CreateCityResponse>(cityService.addCity(createCityRequest), HttpStatus.CREATED);
    }
}
