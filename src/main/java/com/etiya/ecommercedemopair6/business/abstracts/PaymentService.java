package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.payment.CreatePaymentRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.payment.GetAllPaymentsResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.payment.GetPaymentResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.BasketDetail;
import com.etiya.ecommercedemopair6.entities.concretes.Payment;
import com.etiya.ecommercedemopair6.entities.concretes.Product;
import com.etiya.ecommercedemopair6.entities.concretes.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface PaymentService {
    DataResult<GetPaymentResponse >getById(int id);

   DataResult<List<GetAllPaymentsResponse>> getAllPayments();

    Result createPayment(CreatePaymentRequest createPaymentRequest);

    DataResult<Page<Payment>> findAll(Pageable pageable);
    DataResult<Slice<Payment>> findAllSlice(Pageable pageable);

}
