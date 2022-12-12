package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.StreetService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.street.CreateStreetRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.street.CreateStreetResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.street.GetAllStreetsResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.street.GetStreetResponse;
import com.etiya.ecommercedemopair6.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemopair6.core.util.result.SuccessResult;
import com.etiya.ecommercedemopair6.entities.concretes.Street;
import com.etiya.ecommercedemopair6.repository.abstracts.StreetRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StreetManager implements StreetService {
    private StreetRepository streetRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<GetStreetResponse>getById(int id) {
        Street street = streetRepository.findById(id).orElseThrow();
        GetStreetResponse response = modelMapperService.forResponse().map(street,GetStreetResponse.class);
        return new SuccessDataResult<>(response, Message.Street.getByStreetId);
    }

    @Override
    public DataResult<List<GetAllStreetsResponse>> getAllServices() {
        List<Street> streets = streetRepository.findAll();
        List<GetAllStreetsResponse> responses = streets.stream()
                .map(street -> modelMapperService.forResponse().map(street, GetAllStreetsResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(responses,Message.Street.getAllStreets);
    }

    @Override
    public Result createStreet(CreateStreetRequest createStreetRequest) {
 
//        Street street =new Street();
//        street.setStreetName(createStreetRequest.getStreetName());
//        Street savedStreet=streetRepository.save(street);
//        CreateStreetResponse response=new CreateStreetResponse(savedStreet.getStreetName());
        checkIfExistsStreetName(createStreetRequest.getStreetName());


        Street street=modelMapperService.forRequest().map(createStreetRequest,Street.class);
        Street savedStreet = streetRepository.save(street);
        CreateStreetResponse response = modelMapperService.forResponse().map(savedStreet,CreateStreetResponse.class);
        return new SuccessResult(Message.Street.createStreet);
    }

    private void checkIfExistsStreetName(String streetName) {
        boolean isExists = streetRepository.existsByStreetName(streetName);
        if (isExists){
            throw new BusinessException(Message.Street.runTimeException);

        }

    }

    public void checkIfExistsStreetId(int id){
        boolean isExists = streetRepository.existsById(id);
        if (!isExists){
            throw new BusinessException(Message.Street.runTimeException);
        }
    }
}
