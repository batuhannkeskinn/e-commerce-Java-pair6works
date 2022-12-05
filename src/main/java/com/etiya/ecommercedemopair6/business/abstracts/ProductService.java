package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.product.CreateProductRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.product.CreateProductResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(int id);

    List<Product> getAllByStockGreaterThan(int stock);

    Product findByName(String name);

    CreateProductResponse createProduct(CreateProductRequest createProductRequest);
}
