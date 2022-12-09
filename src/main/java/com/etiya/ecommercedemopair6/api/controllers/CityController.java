package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.CityService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.city.CreateCityRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.CreateCityResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.GetAllCityResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.GetCityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/getAll")
    public List<GetAllCityResponse> getAll(){
        return cityService.getAll();
    }

    @GetMapping("/getById")
    public GetCityResponse getById(@RequestParam int id){
        return cityService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<CreateCityResponse> createCity(CreateCityRequest createCityRequest){
        return new ResponseEntity<CreateCityResponse>(cityService.addCity(createCityRequest), HttpStatus.CREATED);
    }
}
