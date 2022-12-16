package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.AddressService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.address.CreateAddressRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.GetAddressResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.GetAllAddressResponse;
import com.etiya.ecommercedemopair6.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemopair6.core.util.result.SuccessResult;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.repository.abstracts.AddressRepository;
import com.etiya.ecommercedemopair6.repository.abstracts.CityRepository;
import com.etiya.ecommercedemopair6.repository.abstracts.CountryRepository;
import com.etiya.ecommercedemopair6.repository.abstracts.StreetRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {
    private MessageSource messageSource;
    private AddressRepository addressRepository;
    private CityRepository cityRepository;
    private CountryRepository countryRepository;
    private StreetRepository streetRepository;
    private ModelMapperService modelMapperService;


    @Override
    public DataResult<GetAddressResponse> getById(int id) {
        Address address = addressRepository.findById(id).orElseThrow();
        GetAddressResponse response = modelMapperService.forResponse().map(address, GetAddressResponse.class);
        return new SuccessDataResult<>(response, messageSource.getMessage(Message.Address.getById,null,
                LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<List<GetAllAddressResponse>> getAll() {
        List<Address> addresses = addressRepository.findAll();
        List<GetAllAddressResponse> responses = addresses.
                stream().map
                        (address -> modelMapperService.forResponse().map
                                (address, GetAllAddressResponse.class))
                .collect(Collectors.toList());
           return new SuccessDataResult<>(responses, messageSource.getMessage(Message.Address.getAllAddress,null
           ,LocaleContextHolder.getLocale()));
    }

    @Override
    public List<Address> findAddressByCityByCityName(String cityName) {
        return addressRepository.customeCityAddress(cityName);

    }

    @Override
    public DataResult<List<GetAllAddressResponse>> getAllAddressByTitle(String title) {
        List<Address> addresses = addressRepository.findAllAddressByTitle(title);
        List<GetAllAddressResponse> responses = addresses.
                stream().map
                        (address -> modelMapperService.forResponse().map
                                (address, GetAllAddressResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(responses,
                messageSource.getMessage( Message.Address.getAllAddress, null,LocaleContextHolder.getLocale()));

    }

    @Override
    public DataResult<GetAddressResponse> getByIdJPQLMethod(int id) {
        Address address = addressRepository.customAddress(id);
        GetAddressResponse response = modelMapperService.forResponse().map(address, GetAddressResponse.class);
        return new SuccessDataResult<>(response,messageSource.getMessage(Message.Address.getById,null,LocaleContextHolder.getLocale()) );
    }

    @Override
    public Result addAddress(CreateAddressRequest createAddressRequest) {
        checkIfExistsCountryId(createAddressRequest.getCountryId());
        checkIfExistsCityId(createAddressRequest.getCityId());
        checkIfExistsStreetId(createAddressRequest.getStreetId());
        Address address = modelMapperService.forRequest().map(createAddressRequest, Address.class);
        Address saveAddress = addressRepository.save(address);
        return new SuccessResult(Message.Address.createAddress);

    }

    @Override
    public DataResult<Page<Address>> findAll(Pageable pageable) {
        return new SuccessDataResult<>(addressRepository.findAll(pageable),
                messageSource.getMessage(Message.Address.getAllPageable,null,
                        LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Slice<Address>> findAllSlice(Pageable pageable) {
        return new SuccessDataResult<>(addressRepository.findAllSlice(pageable),     messageSource.getMessage(Message.Address.getAllPageable,null,
                LocaleContextHolder.getLocale()));
    }

    public void checkIfExistsCityId(int id) {
        boolean isExists = cityRepository.existsById(id);
        if (!isExists) {
            throw new BusinessException(messageSource.getMessage(Message.Address.checkIfExistsAddressId,null,
                    LocaleContextHolder.getLocale()));
        }
    }

    public void checkIfExistsStreetId(int id) {
        boolean isExists = streetRepository.existsById(id);
        if (!isExists) {
            throw new BusinessException(Message.Street.runTimeException);
        }
    }

    public void checkIfExistsCountryId(int id) {
        boolean isExists = countryRepository.existsById(id);
        if (!isExists) {
            throw new BusinessException(Message.Street.runTimeException);
        }
    }

}
