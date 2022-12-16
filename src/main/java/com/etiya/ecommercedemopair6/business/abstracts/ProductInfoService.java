package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.productInfo.CreateProductInfoRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.productInfo.CreateProductInfoResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.productInfo.GetAllProductInfosResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.productInfo.GetProductInfoResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.BasketDetail;
import com.etiya.ecommercedemopair6.entities.concretes.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface ProductInfoService  {
    DataResult<GetProductInfoResponse> getById(int id);

    DataResult<List<GetAllProductInfosResponse>> getAllProductInfos();
    Result createProduct(CreateProductInfoRequest createProductInfoRequest);

    DataResult<Page<ProductInfo>> findAll(Pageable pageable);
    DataResult<Slice<ProductInfo>> findAllSlice(Pageable pageable);

}
