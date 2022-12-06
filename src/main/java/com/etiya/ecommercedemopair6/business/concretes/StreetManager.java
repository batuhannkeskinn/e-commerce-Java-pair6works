package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.StreetService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.street.CreateStreetRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.street.CreateStreetResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Street;
import com.etiya.ecommercedemopair6.repository.abstracts.StreetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class StreetManager implements StreetService {
    private StreetRepository streetRepository;

    @Override
    public Street getById(int id) {
        return streetRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Street> getAllServices() {
        return streetRepository.findAll();
    }

    @Override
    public CreateStreetResponse createStreet(CreateStreetRequest createStreetRequest) {
 
        Street street =new Street();
        street.setStreetName(createStreetRequest.getStreetName());
        Street savedStreet=streetRepository.save(street);
        CreateStreetResponse response=new CreateStreetResponse(savedStreet.getStreetName());
        return response;

    }
}
