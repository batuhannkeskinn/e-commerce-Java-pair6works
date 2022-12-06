package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.CityService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.city.CreateCityRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.CreateCityResponse;
import com.etiya.ecommercedemopair6.entities.concretes.City;
import com.etiya.ecommercedemopair6.repository.abstracts.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getAll(){
        return cityRepository.findAll();
    }

    @Override
    public City getById(int id) {
        return cityRepository.findById(id).orElseThrow();

    }

    @Override
    public List<City> findAllCityByCityName(String name) {
        List<City> response = cityRepository.findAllCityByCityName(name);
        return response;
    }

    @Override
    public CreateCityResponse addCity(CreateCityRequest createCityRequest) {
        City city = new City();
        city.setCityName(createCityRequest.getCityName());
        City savedCity = cityRepository.save(city);
        CreateCityResponse response = new CreateCityResponse(savedCity.getCityName());
        return response;
    }
}
