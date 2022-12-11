package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.brand.CreateBrandRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.brand.CreateBrandResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.brand.GetAllBrandResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.brand.GetBrandResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;

import java.util.List;

public interface BrandService {
    DataResult<GetBrandResponse> getById(int id);
    DataResult<List<GetAllBrandResponse>> getAllBrand();
     Result createBrand(CreateBrandRequest createBrandRequest);


}
