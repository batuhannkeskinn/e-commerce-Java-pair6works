package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.customer.CreateCustomerRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.customer.CreateCustomerResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.customer.GetAllCustomersResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.customer.GetCustomerResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.BasketDetail;
import com.etiya.ecommercedemopair6.entities.concretes.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface CustomerService {
    DataResult<List<GetAllCustomersResponse> >getAll();

    DataResult<GetCustomerResponse >getById(int id);

    DataResult<List<GetAllCustomersResponse> >getAllByFirstName(String name);

    DataResult<GetCustomerResponse >customById(int id);

    Result createCustomer(CreateCustomerRequest createCustomerRequest);

    DataResult<Page<Customer>> findAll(Pageable pageable);
    DataResult<Slice<Customer>> findAllSlice(Pageable pageable);



}
