package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.categoryProduct.CreateCategoryProductRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.categoryProduct.CreateCategoryProductResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.categoryProduct.GetAllCategoryProductResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.categoryProduct.GetCategoryProductResponse;

import java.util.List;

public interface CategoryProductService   {
   List<GetAllCategoryProductResponse> getAll();

   GetCategoryProductResponse getById(int id);

   CreateCategoryProductResponse createCategoryProduct(CreateCategoryProductRequest createCategoryProductRequest);

}
