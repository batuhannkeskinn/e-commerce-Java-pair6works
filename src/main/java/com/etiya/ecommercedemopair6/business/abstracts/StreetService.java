package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.street.CreateStreetRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.street.CreateStreetResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.street.GetAllStreetsResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.street.GetStreetResponse;

import java.util.List;

public interface StreetService {
    GetStreetResponse getById(int id);
    List<GetAllStreetsResponse> getAllServices();
    CreateStreetResponse createStreet(CreateStreetRequest createStreetRequest);
}
