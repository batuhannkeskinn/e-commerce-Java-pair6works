package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.CategoryProductService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.categoryProduct.CreateCategoryProductRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.categoryProduct.CreateCategoryProductResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.categoryProduct.GetAllCategoryProductResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.categoryProduct.GetCategoryProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/CategoryProducts")
@AllArgsConstructor
public class CategoryProductController {

    @Autowired
    private CategoryProductService categoryProductService;

    @GetMapping("/getAll")
    public List<GetAllCategoryProductResponse> getAll() {
        return categoryProductService.getAll();
    }

    @GetMapping("/getById")
    public GetCategoryProductResponse getById(@RequestParam int id) {
        return categoryProductService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<CreateCategoryProductResponse> addCategoryProduct(@RequestBody CreateCategoryProductRequest createCategoryProductRequest){
        return new ResponseEntity<CreateCategoryProductResponse>(categoryProductService.createCategoryProduct(createCategoryProductRequest), HttpStatus.CREATED);
    }


}
