package com.etiya.ecommercedemopair6.business.dto.response.concretes.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductResponse {
    private String productName;
    private  int stock;
    private double unitPrice;
}
