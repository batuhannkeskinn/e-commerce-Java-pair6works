package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.size.CreateSizeRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.size.CreateSizeResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.size.GetAllSizesResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.size.GetSizeResponse;

import java.util.List;

public interface SizeService {
    GetSizeResponse getById(int id);
    List<GetAllSizesResponse> getAllServices();
    CreateSizeResponse createSize(CreateSizeRequest createSizeRequest);
}
