package com.etiya.ecommercedemopair6.business.dto.request.concretes.delivery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDeliveryRequest {
    private String  DeliveryDate;
    @Min(value = 0)
    private int shippingCompanyId;
    @Min(value = 0)
    private int orderId;
}
