package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.customer.CreateCustomerRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.customer.CreateCustomerResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.customer.GetAllCustomersResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.customer.GetCustomerResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Customer;

import java.util.List;

public interface CustomerService {
    List<GetAllCustomersResponse> getAll();

    GetCustomerResponse getById(int id);

    List<Customer> getAllByFirstName(String name);

    Customer customById(int id);

    CreateCustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest);


}
