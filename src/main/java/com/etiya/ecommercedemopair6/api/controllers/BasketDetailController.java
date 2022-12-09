package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.BasketDetailService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.BasketDetail.CreateBasketDetailRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.CreateBasketDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.GetAllBasketDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.GetBasketDetailResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping(Paths.apiPrefix+"basketdetails")
public class BasketDetailController {

    @Autowired
    private BasketDetailService basketDetailService;

    @GetMapping("/getById")
    public GetBasketDetailResponse getById(int id){
        return basketDetailService.getById(id);
    }
    @GetMapping("/getAll")
    public List<GetAllBasketDetailResponse> getAllBasket(){
        return basketDetailService.getAllBasketDetail();
    }
    @PostMapping("/add")
    public ResponseEntity<CreateBasketDetailResponse> createBasketDetail(CreateBasketDetailRequest createBasketDetailRequest){
        return new ResponseEntity<CreateBasketDetailResponse>(basketDetailService.createBasket(createBasketDetailRequest),HttpStatus.CREATED);
    }
}
