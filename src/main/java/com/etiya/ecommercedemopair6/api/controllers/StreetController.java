package com.etiya.ecommercedemopair6.api.controllers;


import com.etiya.ecommercedemopair6.business.abstracts.StreetService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.street.CreateStreetRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.street.CreateStreetResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.street.GetAllStreetsResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.street.GetStreetResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(Paths.apiPrefix+"street")
public class StreetController {
    @Autowired
    private StreetService streetService;
    @GetMapping("/getById")
    public GetStreetResponse getById(@RequestParam int id){
        return streetService.getById(id);
    }
    @GetMapping("/getAll")
    public List<GetAllStreetsResponse> getAll(){
        return streetService.getAllServices();
    }
    @PostMapping("/add")
    public ResponseEntity<CreateStreetResponse> createStreet(CreateStreetRequest createStreetRequest){
        return new ResponseEntity<>(streetService.createStreet(createStreetRequest), HttpStatus.CREATED);

    }

}
