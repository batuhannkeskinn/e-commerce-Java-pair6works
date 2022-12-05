package com.etiya.ecommercedemopair6.business.dto.request.concretes.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
    private String name;
    private double unitPrice;
    private int stock;
}
