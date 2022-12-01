package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair6.entities.concretes.Customer;
import com.etiya.ecommercedemopair6.repository.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(int id) {
        return customerRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Customer> getAllByFirstName(String name) {
        return customerRepository.findAllCustomersByFirstName(name);
    }
}
