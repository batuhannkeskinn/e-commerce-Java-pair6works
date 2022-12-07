package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.AddressService;
import com.etiya.ecommercedemopair6.business.abstracts.CityService;
import com.etiya.ecommercedemopair6.business.abstracts.CountyService;
import com.etiya.ecommercedemopair6.business.abstracts.StreetService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.address.CreateAddressRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.CreateAddressResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.GetAddressResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.GetAllAddressResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.repository.abstracts.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    private final SizeRepository sizeRepository;

    @Override
    public GetAddressResponse getById(int id) {
        Address address = addressRepository.findById(id).orElseThrow();
        GetAddressResponse response = modelMapperService.forResponse().map(address, GetAddressResponse.class);
        return response;
    }

    @Override
    public List<GetAllAddressResponse> getAll() {

        List<Address> addresses = addressRepository.findAll();
        List<GetAllAddressResponse> responses = addresses.
                stream().map
                        (address -> modelMapperService.forResponse().map
                                (address, GetAllAddressResponse.class))
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public List<GetAllAddressResponse> getAllAddressByTitle(String title) {
        List<Address> addresses = addressRepository.findAllAddressByTitle(title);
        List<GetAllAddressResponse> responses = addresses.
                stream().map
                        (address -> modelMapperService.forResponse().map
                                (address, GetAllAddressResponse.class))
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public GetAddressResponse getByIdJPQLMethod(int id) {
        Address address = addressRepository.customAddress(id);
        GetAddressResponse response = modelMapperService.forResponse().map(address,GetAddressResponse.class);
        return response;
    }

    @Override
    public CreateAddressResponse addAddress(CreateAddressRequest createAddressRequest) {

        checkIfExistsCountryId(createAddressRequest.getCountryId());
        checkIfExistsCityId(createAddressRequest.getCityId());
        checkIfExistsStreetId(createAddressRequest.getStreetId());
//***********************************ManuelMapper******************************************
//      City city = cityService.getById(createAddressRequest.getCityId());
//      Street street = streetService.getById(createAddressRequest.getStreetId());
//      Country country = countyService.getById((createAddressRequest.getCountryId()));
        //Response = Alıcı, Request = Aracı , SET işlemlerimiz ise = Üretici
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
