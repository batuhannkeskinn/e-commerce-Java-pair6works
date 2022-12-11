package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.OrderDetailService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.orderDetail.CreateOrderDetailRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.orderDetail.CreateOrderDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.orderDetail.GetAllOrderDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.orderDetail.GetOrderDetailResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
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
@RequestMapping(Paths.apiPrefix+"orderdetails")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;


    @GetMapping("/getById")
    public ResponseEntity<DataResult<GetOrderDetailResponse>> getById(int id) {
        return  new ResponseEntity<>(orderDetailService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<GetAllOrderDetailResponse>>> getAllOrderDetails() {
        return new ResponseEntity<>(orderDetailService.getAllOrderDetails(),HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<Result> createOrderDetail(CreateOrderDetailRequest
                                                                        createOrderDetailRequest) {
        return new ResponseEntity<>(orderDetailService.createOrderDetail(createOrderDetailRequest), HttpStatus.CREATED);
    }
}
