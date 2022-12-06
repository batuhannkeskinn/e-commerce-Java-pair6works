package com.etiya.ecommercedemopair6.business.dto.request.concretes.orderDetail;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateOrderDetailRequest {
    private int orderId;
    private int productId;
}
