package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.address.CreateAddressRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.CreateAddressResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.GetAddressResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.GetAllAddressResponse;

import java.util.List;

public interface AddressService {
    GetAddressResponse getById(int id);

    List<GetAllAddressResponse> getAll();

    List<GetAllAddressResponse> getAllAddressByTitle(String title);

    GetAddressResponse getByIdJPQLMethod(int id);

    CreateAddressResponse addAddress(CreateAddressRequest createAddressRequest);

    //Address getAllCitiesByAddresId(int id);

}
