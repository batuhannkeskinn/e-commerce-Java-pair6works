package com.etiya.ecommercedemopair6.business.dto.request.concretes.BasketDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBasketDetailRequest {
    private int quantity;

    @Min(value = 0)
    private int basketId;

    @Min(value = 0)
    private int productId;

}
