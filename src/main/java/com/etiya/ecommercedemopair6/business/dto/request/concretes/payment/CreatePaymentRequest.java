package com.etiya.ecommercedemopair6.business.dto.request.concretes.payment;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
public class CreatePaymentRequest {
    private String bankName;
    private String cardNumber;
    @Min(value = 0)

    private int orderId; //join
}
