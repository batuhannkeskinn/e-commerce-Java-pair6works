package com.etiya.ecommercedemopair6.business.dto.request.concretes.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
    @NotNull(message = "Ürün ismi boş bırakılamaz.")
    @NotBlank(message = "Ürün ismi boş olamaz.")
    @Min(value = 3 , message = "Minimum 3 karakter")
    @Max(value = 50 , message = "Max 50 karakter")
    private String name;
    @Min(value = 0, message = "0 dan düşük değer giremezsin")
    private int stock;
    @Min(value = 1, message = "1 den düşük değer giremezsin")
    private double unitPrice;
    private int supplierId;
}

