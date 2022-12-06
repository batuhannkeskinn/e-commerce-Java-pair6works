package com.etiya.ecommercedemopair6.business.dto.request.concretes.BasketDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBasketDetailRequest {
    private int quantity;
    private int basketId;
    private int productId;

}
