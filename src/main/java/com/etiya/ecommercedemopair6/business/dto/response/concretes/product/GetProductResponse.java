package com.etiya.ecommercedemopair6.business.dto.response.concretes.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductResponse {
    private String name;
    private  int stock;
    private double unitPrice;

    public GetProductResponse(String name) {
        this.name = name;
    }
}
