package com.etiya.ecommercedemopair6.business.dto.response.concretes.productInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductInfoResponse {
    private int brandId; //join
    private int colorId; //join
    private int sizeId; //join
    private int productId; //join

}
