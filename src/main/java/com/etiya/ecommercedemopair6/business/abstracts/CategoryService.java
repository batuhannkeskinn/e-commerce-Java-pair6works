package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.category.CreateCategoryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.category.CreateCategoryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.category.GetAllCategoryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.category.GetCategoryResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.BasketDetail;
import com.etiya.ecommercedemopair6.entities.concretes.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import javax.xml.crypto.Data;
import java.util.List;

public interface CategoryService {
    DataResult<List<GetAllCategoryResponse> >getAll();
    DataResult<GetCategoryResponse> getById(int id);
    DataResult<List<GetAllCategoryResponse>> getAllCategoriesNameDesc(String name);
    DataResult<GetCategoryResponse>customFindName(int id);
    Result createCategory(CreateCategoryRequest createCategoryRequest);

    DataResult<Page<Category>> findAll(Pageable pageable);
    DataResult<Slice<Category>> findAllSlice(Pageable pageable);

}

