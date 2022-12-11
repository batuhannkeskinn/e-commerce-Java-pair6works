package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.BasketDetailService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.BasketDetail.CreateBasketDetailRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.CreateBasketDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.GetAllBasketDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.GetBasketDetailResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping(Paths.apiPrefix+"basketdetails")
public class BasketDetailController {

    @Autowired
    private BasketDetailService basketDetailService;

    @GetMapping("/getById")
    public ResponseEntity<DataResult<GetBasketDetailResponse>> getById(@RequestParam int id){
        return new ResponseEntity<DataResult<GetBasketDetailResponse>>(basketDetailService.getById(id),HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<GetAllBasketDetailResponse>>> getAllBasket(){
        return new ResponseEntity<DataResult<List<GetAllBasketDetailResponse>>>(basketDetailService.getAllBasketDetail(),HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Result> createBasketDetail(@RequestBody CreateBasketDetailRequest createBasketDetailRequest) {
        return new ResponseEntity<Result>(basketDetailService.createBasket(createBasketDetailRequest), HttpStatus.CREATED);
    }
}
