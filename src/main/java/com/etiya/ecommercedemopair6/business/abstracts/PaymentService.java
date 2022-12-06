package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.payment.CreatePaymentRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.payment.CreatePaymentResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Payment;

import java.util.List;

public interface PaymentService {
    Payment getById(int id);

    List<Payment> getAllPayments();

    CreatePaymentResponse createPayment(CreatePaymentRequest createPaymentRequest);
}
