package com.etiya.ecommercedemopair6.business.dto.request.concretes.categoryProduct;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryProductRequest {
    private int categoryId;
    private int productId;


}
