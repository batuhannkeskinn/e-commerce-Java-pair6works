package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.city.CreateCityRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.CreateCityResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.GetAllCityResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.GetCityResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.BasketDetail;
import com.etiya.ecommercedemopair6.entities.concretes.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface CityService {
    DataResult<List<GetAllCityResponse>> getAll();

    DataResult<GetCityResponse> getById(int id);

    DataResult<List<GetAllCityResponse> >findAllCityByCityName(String name);

    Result addCity(CreateCityRequest createCityRequest);

    DataResult<Page<City>> findAll(Pageable pageable);
    DataResult<Slice<City>> findAllSlice(Pageable pageable);

}
