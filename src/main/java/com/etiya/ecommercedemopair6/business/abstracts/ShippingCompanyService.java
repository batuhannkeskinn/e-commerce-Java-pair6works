package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.shippingCompany.CreateShippingCompanyRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.shippingCompany.CreateShippingCompanyResponse;
import com.etiya.ecommercedemopair6.entities.concretes.ShippingCompany;

import java.util.List;

public interface ShippingCompanyService {
    ShippingCompany getById(int id);
    List<ShippingCompany> getAllShippingCompanies();
    CreateShippingCompanyResponse createShippingCompany(CreateShippingCompanyRequest createShippingCompanyRequest);
}
