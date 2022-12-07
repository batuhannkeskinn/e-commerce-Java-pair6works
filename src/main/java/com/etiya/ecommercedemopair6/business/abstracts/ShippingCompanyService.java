package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.shippingCompany.CreateShippingCompanyRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.shippingCompany.CreateShippingCompanyResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.shippingCompany.GetAllShippingCompanyResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.shippingCompany.GetShippingCompanyResponse;

import java.util.List;

public interface ShippingCompanyService {
    GetShippingCompanyResponse getById(int id);
    List<GetAllShippingCompanyResponse> getAllShippingCompanies();
    CreateShippingCompanyResponse createShippingCompany(CreateShippingCompanyRequest createShippingCompanyRequest);
}
