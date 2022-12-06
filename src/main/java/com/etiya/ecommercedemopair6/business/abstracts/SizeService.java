package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.size.CreateSizeRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.size.CreateSizeResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Size;

import java.util.List;

public interface SizeService {
    Size getById(int id);
    List<Size> getAllServices();
    CreateSizeResponse createSize(CreateSizeRequest createSizeRequest);
}
