package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.category.CreateCategoryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.category.CreateCategoryResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category getById(int id);
    List<Category> getAllCategoriesNameDesc(String name);
    Category customFindName(int id);
    CreateCategoryResponse createCategory(CreateCategoryRequest createCategoryRequest);

}

