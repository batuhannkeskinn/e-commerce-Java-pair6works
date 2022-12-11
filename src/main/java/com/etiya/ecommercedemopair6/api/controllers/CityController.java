package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.CityService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.city.CreateCityRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.CreateCityResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.GetAllCityResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.GetCityResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
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
    public ResponseEntity<DataResult<List<GetAllCityResponse>>>getAll(){
        return new ResponseEntity<DataResult<List<GetAllCityResponse>>>(cityService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<DataResult<GetCityResponse>> getById(@RequestParam int id){
        return new ResponseEntity<>(cityService.getById(id),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Result> createCity(CreateCityRequest createCityRequest){
        return new ResponseEntity<>(cityService.addCity(createCityRequest), HttpStatus.CREATED);
    }
}
