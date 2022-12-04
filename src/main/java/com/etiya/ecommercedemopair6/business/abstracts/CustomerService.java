package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.entities.concretes.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer>getAll();

    Customer getById(int id);

    List<Customer> getAllByFirstName(String name);

    Customer customById (int id);
}
