package com.etiya.ecommercedemopair6.business.dto.request.concretes.Basket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateBasketRequest {
    private int customerId;
    private int basket_Id;
}
