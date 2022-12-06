package com.etiya.ecommercedemopair6.business.dto.request.concretes.categoryProduct;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryProductRequest {
    @Min(value = 0)
    private int categoryId;
    @Min(value = 0)
    private int productId;


}
