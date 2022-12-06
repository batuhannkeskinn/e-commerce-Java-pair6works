package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.brand.CreateBrandRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.brand.CreateBrandResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Brand;

import java.util.List;

public interface BrandService {
    Brand getById(int id);
    List<Brand> getAllBrand();
     CreateBrandResponse createBrand(CreateBrandRequest createBrandRequest);


}
