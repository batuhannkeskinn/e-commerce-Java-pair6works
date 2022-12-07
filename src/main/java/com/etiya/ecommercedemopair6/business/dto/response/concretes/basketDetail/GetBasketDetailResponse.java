package com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBasketDetailResponse {
    private int basketId;
    private int quantity;
    private int productId;
}
