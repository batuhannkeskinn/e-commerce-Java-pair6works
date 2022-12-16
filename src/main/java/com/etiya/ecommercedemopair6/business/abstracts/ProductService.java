package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.product.CreateProductRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.product.CreateProductResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.product.GetAllProductsResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.product.GetProductResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.BasketDetail;
import com.etiya.ecommercedemopair6.entities.concretes.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface ProductService {

    DataResult<List<GetAllProductsResponse>> getAll();
    DataResult<GetProductResponse >getById(int id);

    DataResult<List<GetAllProductsResponse>>getAllByStockGreaterThan(int stock);

    DataResult<GetProductResponse >findByName(String name);

    Result createProduct(CreateProductRequest createProductRequest);

    DataResult<GetProductResponse> customProductId(int id);
    DataResult<GetProductResponse> customProductId2(int id);

    DataResult<Page<Product>> findAll(Pageable pageable);
    DataResult<Slice<Product>> findAllSlice(Pageable pageable);



}
