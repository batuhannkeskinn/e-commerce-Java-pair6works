package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.OrderDetailService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.orderDetail.CreateOrderDetailRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.orderDetail.CreateOrderDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.orderDetail.GetAllOrderDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.orderDetail.GetOrderDetailResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.OrderDetail;
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
    @GetMapping("/getOrderDetailPages")
    public ResponseEntity<DataResult<Page<OrderDetail>>>getOrderDetailPages (@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return new ResponseEntity<>(orderDetailService.findAll(pageable),HttpStatus.OK);
    }
    @GetMapping("/getOrderDetailSlies")
    public ResponseEntity<DataResult<Slice<OrderDetail>>> getOrderDetailSlice(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return new ResponseEntity<>(orderDetailService.findAllSlice(pageable),HttpStatus.OK);

    }
}
