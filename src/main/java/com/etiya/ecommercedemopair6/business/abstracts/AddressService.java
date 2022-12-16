package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.address.CreateAddressRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.CreateAddressResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.GetAddressResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.address.GetAllAddressResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface AddressService {

    DataResult<GetAddressResponse> getById(int id);

    DataResult<List<GetAllAddressResponse> >getAll();

    List<Address> findAddressByCityByCityName(String cityName);

    DataResult<List<GetAllAddressResponse> > getAllAddressByTitle(String title);

    DataResult<GetAddressResponse> getByIdJPQLMethod(int id);

    Result addAddress(CreateAddressRequest createAddressRequest);

    //Address getAllCitiesByAddresId(int id);
    DataResult<Page<Address>> findAll(Pageable pageable);

    DataResult<Slice<Address>>findAllSlice(Pageable pageable);

}
