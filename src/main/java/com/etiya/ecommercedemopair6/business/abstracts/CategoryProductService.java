package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.categoryProduct.CreateCategoryProductRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.categoryProduct.CreateCategoryProductResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.categoryProduct.GetAllCategoryProductResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.categoryProduct.GetCategoryProductResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;

import java.util.List;

public interface CategoryProductService   {
   DataResult<List<GetAllCategoryProductResponse>> getAll();

   DataResult<GetCategoryProductResponse> getById(int id);

   Result createCategoryProduct(CreateCategoryProductRequest createCategoryProductRequest);

}
