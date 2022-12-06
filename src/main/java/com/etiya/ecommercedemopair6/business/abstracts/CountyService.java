package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.country.CreateCountryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.country.CreateCountryResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Country;

import java.util.List;

public interface CountyService {
    Country getById(int id);
    List<Country> getAllCountry();
    CreateCountryResponse createCountry(CreateCountryRequest createCountryRequest);
}
