package com.etiya.ecommercedemopair6.business.dto.request.concretes.payment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatePaymentRequest {
    private String bankName;
    private String cardNumber;
    private int orderId; //join
}
