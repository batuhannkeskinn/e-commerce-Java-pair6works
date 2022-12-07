package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.CityService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.city.CreateCityRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.CreateCityResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.GetAllCityResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.GetCityResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.entities.concretes.City;
import com.etiya.ecommercedemopair6.repository.abstracts.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityManager implements CityService {
    @Autowired
    private CityRepository cityRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllCityResponse> getAll(){
        List<City> cities = cityRepository.findAll();
        List<GetAllCityResponse> responses = cities
                .stream().map(city -> modelMapperService.forResponse().map(city, GetAllCityResponse.class))
                .collect(Collectors.toList());
        return responses;
    }


    @Override
    public GetCityResponse getById(int id) {
        City city = cityRepository.findById(id).orElseThrow();
        GetCityResponse response = modelMapperService.forResponse().map(city,GetCityResponse.class);
        return response;

    }

    @Override
    public List<GetAllCityResponse> findAllCityByCityName(String name) {
        List<City> cities = cityRepository.findAllCityByCityName(name);
        List<GetAllCityResponse> responses = cities
                .stream().map(city -> modelMapperService.forResponse().map(city, GetAllCityResponse.class))
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public CreateCityResponse addCity(CreateCityRequest createCityRequest) {
        //***********************************ManuelMapper******************************************

//        City city = new City();
//        city.setCityName(createCityRequest.getCityName());
//        City savedCity = cityRepository.save(city);
//        CreateCityResponse response = new CreateCityResponse(savedCity.getCityName());
        
        City city = modelMapperService.forRequest().map(createCityRequest,City.class);
        City savedCity = cityRepository.save(city);
        CreateCityResponse response = modelMapperService.forResponse().map(savedCity,CreateCityResponse.class);
        return response;
    }
}
