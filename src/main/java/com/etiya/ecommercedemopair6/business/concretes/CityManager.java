package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.CityService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.city.CreateCityRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.CreateCityResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.GetAllCityResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.city.GetCityResponse;
import com.etiya.ecommercedemopair6.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemopair6.entities.concretes.City;
import com.etiya.ecommercedemopair6.repository.abstracts.CityRepository;
import com.etiya.ecommercedemopair6.repository.abstracts.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityManager implements CityService {
    @Autowired
    private CityRepository cityRepository;
    private ModelMapperService modelMapperService;
    @Autowired
    private ProductRepository productRepository;
    private MessageSource messageSource;

    @Override
    public DataResult<List<GetAllCityResponse>> getAll() {
        List<City> cities = cityRepository.findAll();
        List<GetAllCityResponse> responses = cities
                .stream().map(city -> modelMapperService.forResponse().map(city, GetAllCityResponse.class))
                .collect(Collectors.toList());
        //return new SuccessDataResult<>(responses, Message.City.getAllCities);
        return new SuccessDataResult<>(responses,messageSource.getMessage(Message.City.getAllCities,null,
                LocaleContextHolder.getLocale()));
    }


    @Override
    public DataResult<GetCityResponse> getById(int id) {
        City city = cityRepository.findById(id).orElseThrow();
        GetCityResponse response = modelMapperService.forResponse().map(city, GetCityResponse.class);
       // return new SuccessDataResult<>(response, Message.City.getByCityId);
        return new SuccessDataResult<>(response,messageSource.getMessage(Message.City.getByCityId,null,
                LocaleContextHolder.getLocale()));

    }

    @Override
    public DataResult<List<GetAllCityResponse>> findAllCityByCityName(String name) {
        List<City> cities = cityRepository.findAllCityByCityName(name);
        List<GetAllCityResponse> responses = cities
                .stream().map(city -> modelMapperService.forResponse().map(city, GetAllCityResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(responses, Message.City.getAllCities);
    }

    @Override
    public DataResult<CreateCityResponse> addCity(CreateCityRequest createCityRequest) {
        //***********************************ManuelMapper******************************************
        checkIfExistsCityName(createCityRequest.getCityName());
//        City city = new City();
//        city.setCityName(createCityRequest.getCityName());
//        City savedCity = cityRepository.save(city);
//        CreateCityResponse response = new CreateCityResponse(savedCity.getCityName());

        City city = modelMapperService.forRequest().map(createCityRequest, City.class);
        City savedCity = cityRepository.save(city);
        CreateCityResponse response = modelMapperService.forResponse().map(savedCity, CreateCityResponse.class);
       // return new SuccessDataResult<>(response, Message.City.createCity);
        return new SuccessDataResult<>(response,messageSource.getMessage(Message.City.createCity,null,
                LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Page<City>> findAll(Pageable pageable) {
        return new SuccessDataResult<>(cityRepository.findAll(pageable),  messageSource.getMessage(Message.Address.getAllPageable,null,
                LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Slice<City>> findAllSlice(Pageable pageable) {
        return new SuccessDataResult<>(cityRepository.findAllSlice(pageable), messageSource.getMessage(Message.Address.getAllPageable,null,
                LocaleContextHolder.getLocale()));
    }

    public void checkIfExistsCityName(String name) {
        boolean isExists = cityRepository.existsByCityName(name);
        if (isExists) {
            throw new BusinessException(Message.City.runTimeException);
        }
    }

}
