package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.AddressService;
import com.etiya.ecommercedemopair6.business.abstracts.CityService;
import com.etiya.ecommercedemopair6.business.abstracts.CountyService;
import com.etiya.ecommercedemopair6.business.abstracts.StreetService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.address.CreateAddressRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.CreateAddressResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.repository.abstracts.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class AddressManager implements AddressService {

    private AddressRepository addressRepository;
    private CityRepository cityRepository;
    private CountryRepository countryRepository;
    private StreetRepository streetRepository;
    private CityService cityService;
    private CountyService countyService;
    private StreetService streetService;
    private ModelMapperService modelMapperService;
    private final CategoryRepository categoryRepository;

    @Override
    public Address getById(int id) {
        return addressRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public List<Address> getAllAddressByTitle(String title) {
        return addressRepository.findAllAddressByTitle(title);
    }

    @Override
    public Address addressTitle(int id) {
        return addressRepository.customAddress(id);
    }

    @Override
    public CreateAddressResponse addAddress(CreateAddressRequest createAddressRequest) {

        checkIfExistsCountryId(createAddressRequest.getCountryId());
        checkIfExistsCityId(createAddressRequest.getCityId());
        checkIfExistsStreetId(createAddressRequest.getStreetId());

//        City city = cityService.getById(createAddressRequest.getCityId());
//        Street street = streetService.getById(createAddressRequest.getStreetId());
//        Country country = countyService.getById((createAddressRequest.getCountryId()));

        Address address = modelMapperService.forRequest().map(createAddressRequest,Address.class);

        Address saveAddress = addressRepository.save(address);

        CreateAddressResponse response = modelMapperService.forResponse().map(saveAddress,CreateAddressResponse.class);

        return response;

        
    }

    public void checkIfExistsCityId(int id){
        boolean isExists = cityRepository.existsById(id);
        if (!isExists){
            throw new RuntimeException("This city not found");
        }
    }
    public void checkIfExistsStreetId(int id){
        boolean isExists = streetRepository.existsById(id);
        if (!isExists){
            throw new RuntimeException("This street not found");
        }
    }
    public void checkIfExistsCountryId(int id){
        boolean isExists = countryRepository.existsById(id);
        if (!isExists){
            throw new RuntimeException("This country not found");
        }
    }

}
