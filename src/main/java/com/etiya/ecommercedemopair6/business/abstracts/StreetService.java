package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.street.CreateStreetRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.street.CreateStreetResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Street;

import java.util.List;

public interface StreetService {
    Street getById(int id);
    List<Street> getAllServices();
    CreateStreetResponse createStreet(CreateStreetRequest createStreetRequest);
}
