package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.country.CreateCountryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.country.CreateCountryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.country.GetAllCountryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.country.GetCountryResponse;

import java.util.List;

public interface CountyService {
    GetCountryResponse getById(int id);
    List<GetAllCountryResponse> getAllCountry();
    CreateCountryResponse createCountry(CreateCountryRequest createCountryRequest);
}
