package com.etiya.ecommercedemopair6.repository.abstracts;

import com.etiya.ecommercedemopair6.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAllCustomersByFirstName(String name);

}
