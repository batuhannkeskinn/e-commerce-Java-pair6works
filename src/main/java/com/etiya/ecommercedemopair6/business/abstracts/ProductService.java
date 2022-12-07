package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.product.CreateProductRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.product.CreateProductResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.product.GetAllProductsResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.product.GetProductResponse;

import java.util.List;

public interface ProductService {

    List<GetAllProductsResponse> getAll();
    GetProductResponse getById(int id);

    List<GetAllProductsResponse> getAllByStockGreaterThan(int stock);

    GetProductResponse findByName(String name);

    CreateProductResponse createProduct(CreateProductRequest createProductRequest);
}
