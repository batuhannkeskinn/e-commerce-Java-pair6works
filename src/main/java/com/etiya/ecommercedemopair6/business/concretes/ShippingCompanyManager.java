package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.ShippingCompanyService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.shippingCompany.CreateShippingCompanyRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.shippingCompany.CreateShippingCompanyResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.shippingCompany.GetAllShippingCompanyResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.shippingCompany.GetShippingCompanyResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemopair6.core.util.result.SuccessResult;
import com.etiya.ecommercedemopair6.entities.concretes.ShippingCompany;
import com.etiya.ecommercedemopair6.repository.abstracts.ShippingCompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShippingCompanyManager implements ShippingCompanyService {
    private ShippingCompanyRepository shippingCompanyRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<GetShippingCompanyResponse>getById(int id) {
        ShippingCompany shippingCompany = shippingCompanyRepository.findById(id).orElseThrow();
        GetShippingCompanyResponse response = modelMapperService.forResponse().map(shippingCompany,GetShippingCompanyResponse.class);
        return new SuccessDataResult<>(response, Message.ShippingCompany.getByShippingCompanyId);
    }

    @Override
    public DataResult<List<GetAllShippingCompanyResponse>> getAllShippingCompanies() {
        List<ShippingCompany> shippingCompanies = shippingCompanyRepository.findAll();
        List<GetAllShippingCompanyResponse> responses = shippingCompanies
                .stream().map(shippingCompany -> modelMapperService.forResponse().map(shippingCompany,GetAllShippingCompanyResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(responses,Message.ShippingCompany.getAllShippingCompanies);
    }

    @Override
    public Result createShippingCompany(CreateShippingCompanyRequest createShippingCompanyRequest) {
        //***********************************ManuelMapper******************************************

//        ShippingCompany company = new ShippingCompany();
//        company.setCompanyName(createShippingCompanyRequest.getCompanyName());
//        ShippingCompany saveCompany = shippingCompanyRepository.save(company);
//        CreateShippingCompanyResponse response = new CreateShippingCompanyResponse(saveCompany.getCompanyName());

        ShippingCompany shippingCompany=modelMapperService.forRequest().map(createShippingCompanyRequest,ShippingCompany.class);
        ShippingCompany savedShippingCompany = shippingCompanyRepository.save(shippingCompany);
        CreateShippingCompanyResponse response = modelMapperService.forResponse().map(savedShippingCompany,CreateShippingCompanyResponse.class);
        return new SuccessResult(Message.ShippingCompany.createShippingCompany);
    }
}
