package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.PaymentService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.payment.CreatePaymentRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.payment.CreatePaymentResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Payment;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/getAll")
    public List<Payment> getAllPayments(){
        return paymentService.getAllPayments();
    }
    @GetMapping("/getById")
    public Payment getById(@RequestParam int id){
        return paymentService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<CreatePaymentResponse> createPayment(@RequestBody CreatePaymentRequest createPaymentRequest){
        return new ResponseEntity<CreatePaymentResponse>(paymentService.createPayment(createPaymentRequest), HttpStatus.CREATED);
    }
}