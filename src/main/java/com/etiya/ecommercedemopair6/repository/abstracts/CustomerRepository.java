package com.etiya.ecommercedemopair6.repository.abstracts;

import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAllCustomersByFirstName(String name);

    boolean existsByCustomerId(int id);

    @Query ("Select cu from Customer as cu where customer_id =:id")
    Customer customById(int id);

    boolean existsByPhoneNumber(String number);
    @Query("Select cu from Customer as cu")
    Slice<Customer> findAllSlice(Pageable pageable);
}
