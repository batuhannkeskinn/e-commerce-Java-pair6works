package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.BrandService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.brand.CreateBrandRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.brand.CreateBrandResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.brand.GetAllBrandResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.brand.GetBrandResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("/getById")
    public ResponseEntity<DataResult<GetBrandResponse>> getById(int id) {
        return new ResponseEntity<DataResult<GetBrandResponse>>(brandService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<GetAllBrandResponse>>> getAllBrand() {
        return new ResponseEntity<DataResult<List<GetAllBrandResponse>>>(brandService.getAllBrand(),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Result> createBrand(CreateBrandRequest createBrandRequest) {
        return new ResponseEntity<Result>(brandService.createBrand(createBrandRequest), HttpStatus.CREATED);
    }
}
