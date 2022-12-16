package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.BasketService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.Basket.CreateBasketRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basket.CreateBasketResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basket.GetAllBasketResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basket.GetBasketResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.Basket;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/getBasketPages")
    public ResponseEntity<DataResult<Page<Basket>>>getBasketPages (@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return new ResponseEntity<>(basketService.findAll(pageable),HttpStatus.OK);
    }
    @GetMapping("/getBasketSlies")
    public ResponseEntity<DataResult<Slice<Basket>>> getBasketSlies(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return new ResponseEntity<>(basketService.findAllSlice(pageable),HttpStatus.OK);

    }
}
