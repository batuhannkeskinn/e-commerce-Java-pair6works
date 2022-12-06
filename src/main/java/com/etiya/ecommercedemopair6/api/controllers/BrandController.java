package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.BrandService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.brand.CreateBrandRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.brand.CreateBrandResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("/getById")
    public Brand getById(int id) {
        return brandService.getById(id);
    }

    @GetMapping("/getAll")
    public List<Brand> getAllBrand() {
        return brandService.getAllBrand();
    }

    @PostMapping("/add")
    public ResponseEntity<CreateBrandResponse> createBrand(CreateBrandRequest createBrandRequest) {
        return new ResponseEntity<CreateBrandResponse>(brandService.createBrand(createBrandRequest), HttpStatus.CREATED);
    }
}
