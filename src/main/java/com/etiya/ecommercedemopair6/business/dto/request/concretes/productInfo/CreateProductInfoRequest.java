package com.etiya.ecommercedemopair6.business.dto.request.concretes.productInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductInfoRequest {
    @Min(value = 0)

    private int brandId; //join
    @Min(value = 0)

    private int colorId; //join
    @Min(value = 0)

    private int sizeId; //join
    @Min(value = 0)

    private int productId; //join
}
