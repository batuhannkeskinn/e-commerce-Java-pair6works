package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.ProductService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.product.CreateProductRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.product.CreateProductResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.product.GetAllProductsResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.product.GetProductResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<GetAllProductsResponse>>> getAll() {
        return new ResponseEntity<>(productService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<DataResult<GetProductResponse>> getById(@RequestParam int id) {
        return  new ResponseEntity<>(productService.getById(id),HttpStatus.OK);
    }


    @GetMapping("customGetById1")
    public ResponseEntity<DataResult<GetProductResponse>> getById1(@RequestParam int id){
        return new ResponseEntity<>(productService.customProductId(id),HttpStatus.OK) ;
    }


    @GetMapping("/getCustomerById2")
    public ResponseEntity<DataResult<GetProductResponse>> getById2(@RequestParam int id){
       return new ResponseEntity<>(productService.customProductId2(id),HttpStatus.OK) ;

    }

    @GetMapping("/getByStockGreaterThan")
    public ResponseEntity<DataResult<List<GetAllProductsResponse>>>getAllByStock(@RequestParam("stock") int stock){
        return  new ResponseEntity<>(productService.getAllByStockGreaterThan(stock),HttpStatus.OK);
    }
    @GetMapping("/getByName")
    public ResponseEntity<DataResult<GetProductResponse>> getByName(@RequestParam("name")String name){
      return  new ResponseEntity<>(productService.findByName(name),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Result> createProduct(@RequestBody CreateProductRequest createProductRequest){
        return new ResponseEntity<>(productService.createProduct(createProductRequest), HttpStatus.CREATED);

    }

}