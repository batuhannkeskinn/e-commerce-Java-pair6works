package com.etiya.ecommercedemopair6.business.dto.request.concretes.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
    @NotNull(message = "Ürün ismi boş bırakılamaz.")
    @NotBlank(message = "Ürün ismi boş olamaz.")
    private String productName;
    @Min(value = 0, message = "0 dan düşük değer giremezsin")
    private int stock;
    @Min(value = 0, message = "0 dan düşük değer giremezsin")
    private double unitPrice;
}

