package com.etiya.ecommercedemopair6.business.dto.response.concretes.categoryProduct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCategoryProductResponse {
    private int categoryId;
    private int productId;
}
