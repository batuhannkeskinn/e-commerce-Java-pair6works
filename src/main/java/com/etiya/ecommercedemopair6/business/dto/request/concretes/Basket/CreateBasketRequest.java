package com.etiya.ecommercedemopair6.business.dto.request.concretes.Basket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateBasketRequest {
    @Min(value = 0)

    private int customerId;
    @Min(value = 0)

    private int basket_Id;
}
