package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.brand.CreateBrandRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.brand.CreateBrandResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.brand.GetAllBrandResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.brand.GetBrandResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.BasketDetail;
import com.etiya.ecommercedemopair6.entities.concretes.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface BrandService {
    DataResult<GetBrandResponse> getById(int id);
    DataResult<List<GetAllBrandResponse>> getAllBrand();
     Result createBrand(CreateBrandRequest createBrandRequest);

    DataResult<Page<Brand>> findAll(Pageable pageable);
    DataResult<Slice<Brand>> findAllSlice(Pageable pageable);


}
