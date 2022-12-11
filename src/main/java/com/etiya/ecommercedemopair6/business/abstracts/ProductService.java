package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.product.CreateProductRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.product.CreateProductResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.product.GetAllProductsResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.product.GetProductResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;

import java.util.List;

public interface ProductService {

    DataResult<List<GetAllProductsResponse>> getAll();
    DataResult<GetProductResponse >getById(int id);

   DataResult<List<GetAllProductsResponse>>getAllByStockGreaterThan(int stock);

    DataResult<GetProductResponse >findByName(String name);

    Result createProduct(CreateProductRequest createProductRequest);


    DataResult<GetProductResponse> customProductId(int id);
    DataResult<GetProductResponse> customProductId2(int id);

}
