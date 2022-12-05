package com.etiya.ecommercedemopair6.business.abstracts;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.address.CreateAddressRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.CreateAddressResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Address;


import java.util.List;

public interface AddressService {
    Address getById(int id);

    List<Address> getAll();

    List<Address> getAllAddressByTitle(String title);

    Address addressTitle(int id);

    CreateAddressResponse addAddress(CreateAddressRequest createAddressRequest);

    //Address getAllCitiesByAddresId(int id);

}
