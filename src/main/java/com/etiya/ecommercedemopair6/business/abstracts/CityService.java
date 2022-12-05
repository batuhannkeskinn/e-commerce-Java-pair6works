package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.city.CreateCityRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.CreateCityResponse;
import com.etiya.ecommercedemopair6.entities.concretes.City;

import java.util.List;

public interface CityService {
    List<City> getAll();

    City getById(int id);

    List<City> findAllCityByCityName(String name);

    CreateCityResponse addCity(CreateCityRequest createCityRequest);
}
