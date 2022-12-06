package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.ShippingCompanyService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.shippingCompany.CreateShippingCompanyRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.shippingCompany.CreateShippingCompanyResponse;
import com.etiya.ecommercedemopair6.entities.concretes.ShippingCompany;
import com.etiya.ecommercedemopair6.repository.abstracts.ShippingCompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ShippingCompanyManager implements ShippingCompanyService {
    private ShippingCompanyRepository shippingCompanyRepository;

    @Override
    public ShippingCompany getById(int id) {
        return shippingCompanyRepository.findById(id).orElseThrow();
    }

    @Override
    public List<ShippingCompany> getAllShippingCompanies() {
        return shippingCompanyRepository.findAll();
    }

    @Override
    public CreateShippingCompanyResponse createShippingCompany(CreateShippingCompanyRequest createShippingCompanyRequest) {
        ShippingCompany company = new ShippingCompany();
        company.setCompanyName(createShippingCompanyRequest.getCompanyName());
        ShippingCompany saveCompany = shippingCompanyRepository.save(company);
        CreateShippingCompanyResponse response = new CreateShippingCompanyResponse(saveCompany.getCompanyName());
        return response;
    }
}