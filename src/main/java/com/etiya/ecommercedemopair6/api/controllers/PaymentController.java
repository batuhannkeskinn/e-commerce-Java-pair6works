package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.PaymentService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.payment.CreatePaymentRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.payment.CreatePaymentResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.payment.GetAllPaymentsResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.payment.GetPaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<GetAllPaymentsResponse> getAllPayments(){
        return paymentService.getAllPayments();
    }
    @GetMapping("/getById")
    public GetPaymentResponse getById(@RequestParam int id){
        return paymentService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<CreatePaymentResponse> createPayment(@RequestBody CreatePaymentRequest createPaymentRequest){
        return new ResponseEntity<CreatePaymentResponse>(paymentService.createPayment(createPaymentRequest), HttpStatus.CREATED);
    }
}
