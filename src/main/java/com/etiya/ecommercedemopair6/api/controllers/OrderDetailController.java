package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.OrderDetailService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.orderDetail.CreateOrderDetailRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.orderDetail.CreateOrderDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.orderDetail.GetAllOrderDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.orderDetail.GetOrderDetailResponse;
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
@AllArgsConstructor
@RequestMapping("/api/orderdetails")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;


    @GetMapping("/getById")
    public GetOrderDetailResponse getById(int id) {
        return orderDetailService.getById(id);
    }

    @GetMapping("/getAll")
    public List<GetAllOrderDetailResponse> getAllOrderDetails() {
        return orderDetailService.getAllOrderDetails();
    }

    @PostMapping("/add")
    ResponseEntity<CreateOrderDetailResponse> createOrderDetail(CreateOrderDetailRequest
                                                                        createOrderDetailRequest) {
        return new ResponseEntity<>(orderDetailService.createOrderDetail(createOrderDetailRequest), HttpStatus.CREATED);
    }
}
