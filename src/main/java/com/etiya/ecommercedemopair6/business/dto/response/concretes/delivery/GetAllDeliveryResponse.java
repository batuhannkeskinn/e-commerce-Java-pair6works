package com.etiya.ecommercedemopair6.business.dto.response.concretes.delivery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDeliveryResponse {
    private String deliveryDate;
    private int shippingCompanyId;
    private int orderId;
}
