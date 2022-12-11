package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.SizeService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.size.CreateSizeRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.size.CreateSizeResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.size.GetAllSizesResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.size.GetSizeResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"size")
public class SizeController {
    @Autowired
    private SizeService sizeService;


    @GetMapping("/getById")

    public ResponseEntity<DataResult<GetSizeResponse> >getById(int id) {

     return  new ResponseEntity<>(sizeService.getById(id),HttpStatus.OK) ;
    }

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<GetAllSizesResponse>> >getAllSizes(){
        return new ResponseEntity<>(sizeService.getAllServices(),HttpStatus.OK);
    }


     @PostMapping("/add")
     public ResponseEntity<Result> createSize(CreateSizeRequest createSizeRequest){
        return new ResponseEntity<>(sizeService.createSize(createSizeRequest), HttpStatus.CREATED);
    }
}
