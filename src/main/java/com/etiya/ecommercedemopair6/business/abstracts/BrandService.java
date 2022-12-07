package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.brand.CreateBrandRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.brand.CreateBrandResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.brand.GetAllBrandResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.brand.GetBrandResponse;

import java.util.List;

public interface BrandService {
    GetBrandResponse getById(int id);
    List<GetAllBrandResponse> getAllBrand();
     CreateBrandResponse createBrand(CreateBrandRequest createBrandRequest);


}
