package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.SizeService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.size.CreateSizeRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.size.CreateSizeResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.size.GetAllSizesResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.size.GetSizeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sizes")
public class SizeController {
    @Autowired
    private SizeService sizeService;


    @GetMapping("/getById")

    public GetSizeResponse getById(int id) {
     return   sizeService.getById(id);
    }

    @GetMapping("/getAll")
    public List<GetAllSizesResponse> getAllSizes(){
        return sizeService.getAllServices();
    }


     @PostMapping("/add")
     public ResponseEntity<CreateSizeResponse> createSize(CreateSizeRequest createSizeRequest){
        return new ResponseEntity<>(sizeService.createSize(createSizeRequest), HttpStatus.CREATED);
    }
}
