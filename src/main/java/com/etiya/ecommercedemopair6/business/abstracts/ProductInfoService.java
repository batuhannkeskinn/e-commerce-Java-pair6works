package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.productInfo.CreateProductInfoRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.productInfo.CreateProductInfoResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.productInfo.GetAllProductInfosResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.productInfo.GetProductInfoResponse;

import java.util.List;

public interface ProductInfoService  {
    GetProductInfoResponse getById(int id);

    List<GetAllProductInfosResponse> getAllProductInfos();
    CreateProductInfoResponse createProduct2(CreateProductInfoRequest createProductInfoRequest);
}
