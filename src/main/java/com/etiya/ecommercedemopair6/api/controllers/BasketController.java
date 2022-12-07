package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.BasketService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.Basket.CreateBasketRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basket.CreateBasketResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basket.GetAllBasketResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basket.GetBasketResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/baskets")
@AllArgsConstructor
public class BasketController {
    @Autowired
    private BasketService basketService;

    @GetMapping("/getById")
    public GetBasketResponse getById(int id){
        return basketService.getById(id);
    }
    @GetMapping("/getAll")
    public List<GetAllBasketResponse> getAll(){
        return basketService.getAllBasket();
    }
    @PostMapping("/add")
    public ResponseEntity<CreateBasketResponse> createBasket(CreateBasketRequest createBasketResponse){
        return new ResponseEntity<CreateBasketResponse>(basketService.createBasket(createBasketResponse), HttpStatus.CREATED);
    }
}
