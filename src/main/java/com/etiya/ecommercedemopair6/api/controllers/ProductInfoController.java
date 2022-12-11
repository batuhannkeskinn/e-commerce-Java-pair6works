package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.ProductInfoService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.productInfo.CreateProductInfoRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.productInfo.CreateProductInfoResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.productInfo.GetAllProductInfosResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.productInfo.GetProductInfoResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(Paths.apiPrefix+"/productInfos")
public class ProductInfoController {
    @Autowired
    private ProductInfoService productInfoService;


    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<GetAllProductInfosResponse>>> getAll() {
        return new ResponseEntity<DataResult<List<GetAllProductInfosResponse>>>(productInfoService.getAllProductInfos(),HttpStatus.OK) ;
    }

    @GetMapping("/getById")
    public ResponseEntity<DataResult<GetProductInfoResponse>> getById(@RequestParam int id) {
        return  new ResponseEntity<DataResult<GetProductInfoResponse>>(productInfoService.getById(id),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Result> createProductInfo(CreateProductInfoRequest createProductInfoRequest) {
        return new ResponseEntity<>(productInfoService.createProduct(createProductInfoRequest), HttpStatus.CREATED);

    }
}
