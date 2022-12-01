package com.etiya.ecommercedemopair6.repository.abstracts;

import com.etiya.ecommercedemopair6.entities.concretes.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> findByTitle(String title);
}
