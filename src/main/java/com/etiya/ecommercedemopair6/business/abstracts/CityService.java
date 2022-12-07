package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.city.CreateCityRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.CreateCityResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.GetAllCityResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.GetCityResponse;

import java.util.List;

public interface CityService {
    List<GetAllCityResponse> getAll();

    GetCityResponse getById(int id);

    List<GetAllCityResponse> findAllCityByCityName(String name);

    CreateCityResponse addCity(CreateCityRequest createCityRequest);
}
