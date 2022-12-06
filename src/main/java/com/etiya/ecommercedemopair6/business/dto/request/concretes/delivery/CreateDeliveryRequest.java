package com.etiya.ecommercedemopair6.business.dto.request.concretes.delivery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDeliveryRequest {
    private String  DeliveryDate;
    private int shippingCompanyId;
    private int orderId;
}
