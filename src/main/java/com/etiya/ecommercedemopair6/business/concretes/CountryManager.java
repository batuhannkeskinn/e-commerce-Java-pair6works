package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.CountyService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.country.CreateCountryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.country.CreateCountryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.country.GetAllCountryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.country.GetCountryResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.core.util.result.SuccessDataResult;
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
    public DataResult<GetCountryResponse> getById(int id) {
        Country country =  countryRepository.findById(id).orElseThrow();
        GetCountryResponse response = modelMapperService.forResponse().map(country,GetCountryResponse.class);
        return new SuccessDataResult<>(response,Message.Country.getByCountryId);
    }

    @Override
    public DataResult<List<GetAllCountryResponse>> getAllCountry() {

        List<Country> countries =  countryRepository.findAll();
        List<GetAllCountryResponse> responses = countries.stream()
                .map(country -> modelMapperService.forResponse().map(country, GetAllCountryResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(responses,Message.Country.getAllCountries);
    }


    @Override
    public Result createCountry(CreateCountryRequest createCountryRequest) {
        //***********************************ManuelMapper******************************************
        checkIfExistsCountryId(createCountryRequest.getCountryId());

        /*Country country=new Country();
        country.setCountryName(createCountryRequest.getCountryName());
        Country savedCountry=countryRepository.save(country);*/

        Country country = modelMapperService.forRequest().map(createCountryRequest, Country.class);
        Country saveCountry = countryRepository.save(country);
        CreateCountryResponse response = modelMapperService.forResponse().map(saveCountry, CreateCountryResponse.class);
        return new SuccessDataResult<>(response,Message.Country.createCountry);


    }

    public void checkIfExistsCountryId(int id) {
        boolean isExists = countryRepository.existsById(id);
        if (!isExists) {
            throw new RuntimeException(Message.Country.CheckIfExistsCountryId);
        }
    }
}