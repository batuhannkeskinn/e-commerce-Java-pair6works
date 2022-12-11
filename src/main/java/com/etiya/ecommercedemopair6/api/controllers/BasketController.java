package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.BasketService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.Basket.CreateBasketRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basket.CreateBasketResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basket.GetAllBasketResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basket.GetBasketResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"baskets")
@AllArgsConstructor
public class BasketController {
    @Autowired
    private BasketService basketService;

    @GetMapping("/getById")
    public ResponseEntity<DataResult<GetBasketResponse>> getById(int id){
        return new ResponseEntity<>(basketService.getById(id), HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<GetAllBasketResponse>>>getAll(){
        return new ResponseEntity<>(basketService.getAllBasket(),HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Result> createBasket(CreateBasketRequest createBasketResponse){
        return new ResponseEntity<>(basketService.createBasket(createBasketResponse), HttpStatus.CREATED);
    }
}
