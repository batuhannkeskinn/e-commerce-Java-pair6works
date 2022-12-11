package com.etiya.ecommercedemopair6.business.dto.response.concretes.productInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductInfosResponse {
    private int productInfoId;
    private int brandId; //join
    private int colorId; //join
    private int sizeId; //join
    private int productId; //join
    private String colorName;

}
