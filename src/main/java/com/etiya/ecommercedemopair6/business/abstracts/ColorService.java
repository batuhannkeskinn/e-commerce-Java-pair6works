package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.Color.CreateColorRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.color.CreateColorResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.color.GetAllColorResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.color.GetColorResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.BasketDetail;
import com.etiya.ecommercedemopair6.entities.concretes.Color;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface ColorService {
    DataResult<GetColorResponse >getById(int id);
    DataResult<List<GetAllColorResponse> >getAllColor();
    Result createColor(CreateColorRequest createColorRequest);

    DataResult<Page<Color>> findAll(Pageable pageable);
    DataResult<Slice<Color>> findAllSlice(Pageable pageable);

}
