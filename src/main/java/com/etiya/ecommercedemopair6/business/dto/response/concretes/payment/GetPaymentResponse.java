package com.etiya.ecommercedemopair6.business.dto.response.concretes.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPaymentResponse {
    private String bankName;
    private String cardNumber;
    private int orderId; //join
}
