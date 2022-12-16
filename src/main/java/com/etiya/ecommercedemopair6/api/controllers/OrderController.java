package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.OrderService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.order.CreateOrderRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.order.CreateOrderResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.order.GetAllOrderResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.order.GetOrderResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Order;
import com.etiya.ecommercedemopair6.entities.concretes.Supplier;
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
@RequestMapping(Paths.apiPrefix+"orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/getById")
    public ResponseEntity<DataResult<GetOrderResponse>> getById(@RequestParam int id){
        return new ResponseEntity<>(orderService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<GetAllOrderResponse>>> getAllOrders(){
        return new ResponseEntity<>( orderService.getAllOrders(),HttpStatus.OK);
    }


    @PostMapping("/add")

    public ResponseEntity<Result> createOrder(@RequestBody CreateOrderRequest createOrderRequest){
        return new ResponseEntity<>(orderService.createOrder(createOrderRequest) ,HttpStatus.CREATED);
    }
    @GetMapping("/getOrderPages")
    public ResponseEntity<DataResult<Page<Order>>>getOrderPages (@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return  new ResponseEntity<>(orderService.findAll(pageable),HttpStatus.OK);
    }
    @GetMapping("/getOrderSlies")
    public ResponseEntity<DataResult<Slice<Order>>> getOrderSlice(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return new ResponseEntity<>(orderService.findAllSlice(pageable),HttpStatus.OK);

    }
}
