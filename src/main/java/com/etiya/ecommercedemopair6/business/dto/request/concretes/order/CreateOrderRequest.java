package com.etiya.ecommercedemopair6.business.dto.request.concretes.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {
    private  int orderNumber;
    private int orderQuantity;
    private double totalPrice;
    private Date orderDate;
    private int customerId; //join
}
