package com.etiya.ecommercedemopair6.business.dto.request.concretes.orderDetail;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
public class CreateOrderDetailRequest {
    @Min(value = 0)
    private int orderDetailId;
    @Min(value = 0)
    private int productId;
    private int supplierId;
}
