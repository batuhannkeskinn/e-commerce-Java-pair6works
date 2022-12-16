package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.CityService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.city.CreateCityRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.CreateCityResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.GetAllCityResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.GetCityResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.City;
import com.etiya.ecommercedemopair6.entities.concretes.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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
    @GetMapping("/getCityPages")
    public ResponseEntity<DataResult<Page<City>>>getCityPages (@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return  new ResponseEntity<>(cityService.findAll(pageable),HttpStatus.OK);
    }
    @GetMapping("/getCitySlies")
    public ResponseEntity<DataResult<Slice<City>>> getCitySlice(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return new ResponseEntity<>(cityService.findAllSlice(pageable),HttpStatus.OK);

    }
}
