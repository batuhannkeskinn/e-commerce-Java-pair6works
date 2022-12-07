package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.category.CreateCategoryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.category.CreateCategoryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.category.GetAllCategoryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.category.GetCategoryResponse;

import java.util.List;

public interface CategoryService {
    List<GetAllCategoryResponse> getAll();
    GetCategoryResponse getById(int id);
    List<GetAllCategoryResponse> getAllCategoriesNameDesc(String name);
    GetCategoryResponse customFindName(int id);
    CreateCategoryResponse createCategory(CreateCategoryRequest createCategoryRequest);

}

