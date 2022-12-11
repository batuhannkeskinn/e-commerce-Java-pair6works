package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.Color.CreateColorRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.color.CreateColorResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.color.GetAllColorResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.color.GetColorResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;

import java.util.List;

public interface ColorService {
    DataResult<GetColorResponse >getById(int id);
    DataResult<List<GetAllColorResponse> >getAllColor();
    Result createColor(CreateColorRequest createColorRequest);
}
