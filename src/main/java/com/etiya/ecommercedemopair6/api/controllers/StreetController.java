package com.etiya.ecommercedemopair6.api.controllers;


import com.etiya.ecommercedemopair6.business.abstracts.StreetService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.street.CreateStreetRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.street.CreateStreetResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.street.GetAllStreetsResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.street.GetStreetResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.coyote.Response;
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
    public ResponseEntity<DataResult<GetStreetResponse>> getById(@RequestParam int id){
        return new ResponseEntity<>(streetService.getById(id),HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<GetAllStreetsResponse>>>getAll(){
        return new ResponseEntity<>(streetService.getAllServices(),HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Result> createStreet(CreateStreetRequest createStreetRequest){
        return new ResponseEntity<>(streetService.createStreet(createStreetRequest), HttpStatus.CREATED);

    }

}
