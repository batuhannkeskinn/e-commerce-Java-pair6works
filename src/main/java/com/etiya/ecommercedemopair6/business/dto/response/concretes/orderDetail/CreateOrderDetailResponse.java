package com.etiya.ecommercedemopair6.business.dto.response.concretes.orderDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDetailResponse {
    private int orderId ;
    private int productId; //join

}
