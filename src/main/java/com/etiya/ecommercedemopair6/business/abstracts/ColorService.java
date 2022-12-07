package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.Color.CreateColorRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.color.CreateColorResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.color.GetAllColorResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.color.GetColorResponse;

import java.util.List;

public interface ColorService {
    GetColorResponse getById(int id);
    List<GetAllColorResponse> getAllColor();
    CreateColorResponse createColor(CreateColorRequest createColorRequest);
}
