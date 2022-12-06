package com.etiya.ecommercedemopair6.business.dto.request.concretes.productInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductInfoRequest {
    private int brandId; //join
    private int colorId; //join
    private int sizeId; //join
    private int productId; //join
}
