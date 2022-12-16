package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.country.CreateCountryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.country.CreateCountryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.country.GetAllCountryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.country.GetCountryResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.BasketDetail;
import com.etiya.ecommercedemopair6.entities.concretes.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface CountyService {
    DataResult<GetCountryResponse> getById(int id);
    DataResult <List<GetAllCountryResponse>> getAllCountry();
    Result createCountry(CreateCountryRequest createCountryRequest);

    DataResult<Page<Country>> findAll(Pageable pageable);
    DataResult<Slice<Country>> findAllSlice(Pageable pageable);

}
