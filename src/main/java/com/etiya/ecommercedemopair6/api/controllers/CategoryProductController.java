package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.CategoryProductService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.categoryProduct.CreateCategoryProductRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.categoryProduct.CreateCategoryProductResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.categoryProduct.GetAllCategoryProductResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.categoryProduct.GetCategoryProductResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"CategoryProducts")
@AllArgsConstructor
public class CategoryProductController {

    @Autowired
    private CategoryProductService categoryProductService;

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<GetAllCategoryProductResponse>>>getAll() {
        return new ResponseEntity<DataResult<List<GetAllCategoryProductResponse>>>(categoryProductService.getAll(),HttpStatus.OK);

    }

    @GetMapping("/getById")
    public ResponseEntity<DataResult<GetCategoryProductResponse>>getById(@RequestParam int id) {
        return new ResponseEntity<DataResult<GetCategoryProductResponse>>(categoryProductService.getById(id),HttpStatus.OK);

    }


    @PostMapping("/add")
    public ResponseEntity<Result>addCategoryProduct(@RequestBody CreateCategoryProductRequest createCategoryProductRequest){
        return new ResponseEntity<Result>(categoryProductService.createCategoryProduct(createCategoryProductRequest), HttpStatus.CREATED);
    }


}
