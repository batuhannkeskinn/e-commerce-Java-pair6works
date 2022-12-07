package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.CountyService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.country.CreateCountryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.country.CreateCountryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.country.GetAllCountryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.country.GetCountryResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.entities.concretes.Country;
import com.etiya.ecommercedemopair6.repository.abstracts.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CountryManager implements CountyService {
    private ModelMapperService modelMapperService;
    private CountryRepository countryRepository;


    @Override
    public GetCountryResponse getById(int id) {
        Country country =  countryRepository.findById(id).orElseThrow();
        GetCountryResponse response = modelMapperService.forResponse().map(country,GetCountryResponse.class);
        return response;
    }

    @Override
    public List<GetAllCountryResponse> getAllCountry() {

        List<Country> countries =  countryRepository.findAll();
        List<GetAllCountryResponse> responses = countries.stream()
                .map(country -> modelMapperService.forResponse().map(country, GetAllCountryResponse.class))
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public CreateCountryResponse createCountry(CreateCountryRequest createCountryRequest) {
        //***********************************ManuelMapper******************************************


        /*Country country=new Country();
        country.setCountryName(createCountryRequest.getCountryName());
        Country savedCountry=countryRepository.save(country);*/

        Country country = modelMapperService.forRequest().map(createCountryRequest, Country.class);
        Country saveCountry = countryRepository.save(country);
        CreateCountryResponse response = modelMapperService.forResponse().map(saveCountry, CreateCountryResponse.class);
        return response;


    }

    public void checkIfExistsCityId(int id) {
        boolean isExists = countryRepository.existsById(id);
        if (!isExists) {
            throw new RuntimeException("This country not found");
        }
    }
}