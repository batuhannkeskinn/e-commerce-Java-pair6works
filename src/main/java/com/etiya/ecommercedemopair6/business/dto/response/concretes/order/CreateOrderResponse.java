package com.etiya.ecommercedemopair6.business.dto.response.concretes.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderResponse {
    private int orderId;
    private  int orderNumber;
    private int orderQuantity;
    private double totalPrice;
    private int customerId; //join

}
