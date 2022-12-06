package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.productInfo.CreateProductInfoRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.productInfo.CreateProductInfoResponse;
import com.etiya.ecommercedemopair6.entities.concretes.ProductInfo;

import java.util.List;

public interface ProductInfoService  {
    ProductInfo getById(int id);

    List<ProductInfo> getAllProductInfos();
    CreateProductInfoResponse createProduct2(CreateProductInfoRequest createProductInfoRequest);
}
