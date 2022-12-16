package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.PaymentService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.payment.CreatePaymentRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.payment.CreatePaymentResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.payment.GetAllPaymentsResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.payment.GetPaymentResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Payment;
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
@RequestMapping(Paths.apiPrefix+"payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<GetAllPaymentsResponse>>> getAllPayments(){
        return  new ResponseEntity<>(paymentService.getAllPayments(),HttpStatus.OK);
    }
    @GetMapping("/getById")
    public ResponseEntity<DataResult<GetPaymentResponse>> getById(@RequestParam int id){
        return new ResponseEntity<>(paymentService.getById(id),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Result> createPayment(@RequestBody CreatePaymentRequest createPaymentRequest){
        return new ResponseEntity<>(paymentService.createPayment(createPaymentRequest), HttpStatus.CREATED);
    }
    @GetMapping("/getPaymentPages")
    public ResponseEntity<DataResult<Page<Payment>>>getPaymentPages (@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return  new ResponseEntity<>(paymentService.findAll(pageable),HttpStatus.OK);
    }
    @GetMapping("/getPaymentSlies")
    public ResponseEntity<DataResult<Slice<Payment>>> getPaymentSlies(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return new ResponseEntity<>(paymentService.findAllSlice(pageable),HttpStatus.OK);

    }
}
