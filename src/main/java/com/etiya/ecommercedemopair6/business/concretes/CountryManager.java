package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.CountyService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.country.CreateCountryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.country.CreateCountryResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Country;
import com.etiya.ecommercedemopair6.repository.abstracts.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryManager implements CountyService {

    private CountryRepository countryRepository;
    @Override
    public Country getById(int id) {
        return countryRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Country> getAllCountry() {
        return countryRepository.findAll();
    }

    @Override
    public CreateCountryResponse createCountry(CreateCountryRequest createCountryRequest) {

        Country country=new Country();
        country.setCountryName(createCountryRequest.getCountryName());
        Country savedCountry=countryRepository.save(country);
        CreateCountryResponse response=new CreateCountryResponse(savedCountry.getCountryName());
        return response;


    }

}
