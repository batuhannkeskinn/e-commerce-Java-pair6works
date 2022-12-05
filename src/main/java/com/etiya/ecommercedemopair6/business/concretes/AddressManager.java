package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.AddressService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.address.CreateAddressRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.CreateAddressResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.repository.abstracts.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressManager implements AddressService {

    private AddressRepository addressRepository;

    public AddressManager(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

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
        Address address = new Address();
        address.setTitle(createAddressRequest.getTitle());
        Address savedAddress = addressRepository.save(address);
        CreateAddressResponse response = new CreateAddressResponse(savedAddress.getTitle());
        return response;
    }


//    @Override
//    public Address getAllCitiesByAddresId(int id) {
   //     Address address = addressRepository.getAllCitiesByAddressId(id);
//        return address;
//    }
}
