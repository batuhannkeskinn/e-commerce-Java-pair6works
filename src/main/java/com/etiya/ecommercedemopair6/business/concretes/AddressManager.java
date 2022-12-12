package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.AddressService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.address.CreateAddressRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.CreateAddressResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.GetAddressResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.GetAllAddressResponse;
import com.etiya.ecommercedemopair6.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemopair6.core.util.result.SuccessResult;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.repository.abstracts.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {

    private AddressRepository addressRepository;
    private CityRepository cityRepository;
    private CountryRepository countryRepository;
    private StreetRepository streetRepository;
    private ModelMapperService modelMapperService;


    @Override
    public  DataResult<GetAddressResponse> getById(int id) {
        Address address = addressRepository.findById(id).orElseThrow();
        GetAddressResponse response = modelMapperService.forResponse().map(address, GetAddressResponse.class);
        return  new SuccessDataResult<>(response, Message.Address.getById);
        //return new SuccessDataResult<>(response, Messages.Address.addressAdded);
    }

    @Override
    public  DataResult<List<GetAllAddressResponse>> getAll() {

        List<Address> addresses = addressRepository.findAll();

        List<GetAllAddressResponse> responses = addresses.
                stream().map
                        (address -> modelMapperService.forResponse().map
                                (address, GetAllAddressResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(responses,Message.Address.getAllAddress);

    }
//    @Override
//    public List<Address> findAddressByCityByCityName(String cityName) {
//        return addressRepository.customeCityAddress(cityName);

//    }

    @Override
    public DataResult<List<GetAllAddressResponse>> getAllAddressByTitle(String title) {


        List<Address> addresses = addressRepository.findAllAddressByTitle(title);
        List<GetAllAddressResponse> responses = addresses.
                stream().map
                        (address -> modelMapperService.forResponse().map
                                (address, GetAllAddressResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(responses,Message.Address.getAllAddress);
    }

    @Override
    public DataResult<GetAddressResponse> getByIdJPQLMethod(int id) {
        Address address = addressRepository.customAddress(id);
        GetAddressResponse response = modelMapperService.forResponse().map(address,GetAddressResponse.class);

        return new SuccessDataResult<>(response,Message.Address.getById);
    }

    @Override
    public Result addAddress(CreateAddressRequest createAddressRequest) {

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

        return new SuccessResult(Message.Address.createAddress);


    }

    public void checkIfExistsCityId(int id){
        boolean isExists = cityRepository.existsById(id);
        if (!isExists){
            throw new BusinessException(Message.City.runTimeException);
        }
    }
    public void checkIfExistsStreetId(int id){
        boolean isExists = streetRepository.existsById(id);
        if (!isExists){
            throw new BusinessException(Message.Street.runTimeException);
        }
    }
    public void checkIfExistsCountryId(int id){
        boolean isExists = countryRepository.existsById(id);
        if (!isExists){
            throw new BusinessException(Message.Street.runTimeException);
        }
    }

}
