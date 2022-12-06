package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.OrderService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.order.CreateOrderRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.order.CreateOrderResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Order;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/getById")
    public Order getById(@RequestParam int id){
        return orderService.getById(id);
    }

    @GetMapping("/getAll")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }


    @PostMapping("/add")

    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequest createOrderRequest){
        return new ResponseEntity<CreateOrderResponse>(orderService.createOrder(createOrderRequest) ,HttpStatus.CREATED);
    }
}
