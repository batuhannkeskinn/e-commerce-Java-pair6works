package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.BasketDetailService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.BasketDetail.CreateBasketDetailRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.CreateBasketDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.GetAllBasketDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.GetBasketDetailResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Basket;
import com.etiya.ecommercedemopair6.entities.concretes.BasketDetail;
import com.etiya.ecommercedemopair6.repository.abstracts.BasketDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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
    @Autowired
    private BasketDetailRepository basketDetailRepository;

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
    @GetMapping("/getBasketDetailPages")
    public ResponseEntity<DataResult<Page<BasketDetail>>>getBasketDetailPages (@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return new ResponseEntity<>(basketDetailService.findAll(pageable),HttpStatus.OK);
    }
    @GetMapping("/getBasketDetailSlies")
    public ResponseEntity<DataResult<Slice<BasketDetail>>> getBasketDetailSlies(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return new ResponseEntity<>(basketDetailService.findAllSlice(pageable),HttpStatus.OK);
    }
}
