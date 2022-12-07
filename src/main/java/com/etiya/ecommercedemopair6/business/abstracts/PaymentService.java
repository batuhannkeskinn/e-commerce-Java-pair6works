package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.payment.CreatePaymentRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.payment.CreatePaymentResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.payment.GetAllPaymentsResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.payment.GetPaymentResponse;

import java.util.List;

public interface PaymentService {
    GetPaymentResponse getById(int id);

    List<GetAllPaymentsResponse> getAllPayments();

    CreatePaymentResponse createPayment(CreatePaymentRequest createPaymentRequest);
}
