package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.ProductInfoService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.productInfo.CreateProductInfoRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.productInfo.CreateProductInfoResponse;
import com.etiya.ecommercedemopair6.entities.concretes.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productInfos")
public class ProductInfoController {
    @Autowired
    private ProductInfoService productInfoService;


    @GetMapping
    public List<ProductInfo> getAll() {
        return productInfoService.getAllProductInfos();
    }

    @GetMapping("/getById")
    public ProductInfo getById(@RequestParam int id) {
        return productInfoService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<CreateProductInfoResponse> createProductInfo(CreateProductInfoRequest createProductInfoRequest) {
        return new ResponseEntity<>(productInfoService.createProduct2(createProductInfoRequest), HttpStatus.CREATED);

    }
}
