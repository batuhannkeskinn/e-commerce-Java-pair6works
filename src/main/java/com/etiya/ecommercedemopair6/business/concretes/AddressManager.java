package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.AddressService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.address.CreateAddressRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.CreateAddressResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.GetAddressResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.GetAllAddressResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.repository.abstracts.AddressRepository;
import com.etiya.ecommercedemopair6.repository.abstracts.CityRepository;
import com.etiya.ecommercedemopair6.repository.abstracts.CountryRepository;
import com.etiya.ecommercedemopair6.repository.abstracts.StreetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {
//
    private AddressRepository addressRepository;
    private CityRepository cityRepository;
    private CountryRepository countryRepository;
    private StreetRepository streetRepository;
    private ModelMapperService modelMapperService;



    @Override
    public GetAddressResponse getById(int id) {
        Address address = addressRepository.findById(id).orElseThrow();
        GetAddressResponse response = modelMapperService.forResponse().map(address, GetAddressResponse.class);
        return response;
    }

    @Override
    public List<GetAllAddressResponse> getAll() {

        List<Address> addresses = addressRepository.findAll();


     /*   [{1,Ev,1,5,6},{2,Ev,2,5,7},{3,iş,4,5,6}

                ]*/

        List<GetAllAddressResponse> responses = addresses.
                stream().map
                        (address -> modelMapperService.forResponse().map
                                (address, GetAllAddressResponse.class))
                .collect(Collectors.toList());

        return responses;
    }
    @Override
    public List<Address> findAddressByCityByCityName(String cityName) {
        return addressRepository.customeCityAddress(cityName);

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
//      Country country = countyService.getById((createAddressRequest.getCountryId())
//          Response = Alıcı, Request = Aracı , SET işlemlerimiz ise = Üretici
        Address address = modelMapperService.forRequest().map(createAddressRequest,Address.class);

        Address saveAddress = addressRepository.save(address);

        CreateAddressResponse response = modelMapperService.forResponse().map(saveAddress,CreateAddressResponse.class);

        return response;


    }

    public void checkIfExistsCityId(int id){
        boolean isExists = cityRepository.existsById(id);
        if (!isExists){
            throw new RuntimeException(Message.City.CheckIfExistsCityId);
        }
    }
    public void checkIfExistsStreetId(int id){
        boolean isExists = streetRepository.existsById(id);
        if (!isExists){
            throw new RuntimeException(Message.Street.CheckIfExistsStreetId);
        }
    }
    public void checkIfExistsCountryId(int id){
        boolean isExists = countryRepository.existsById(id);
        if (!isExists){
            throw new RuntimeException(Message.Country.CheckIfExistsCountryId);
        }
    }

}
