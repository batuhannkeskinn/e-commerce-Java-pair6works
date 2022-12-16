package com.etiya.ecommercedemopair6.repository.abstracts;

import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.ShippingCompany;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShippingCompanyRepository extends JpaRepository<ShippingCompany,Integer> {
    boolean existsByCompanyName(String companyName);
    @Query("Select sc from ShippingCompany as sc")
    Slice<ShippingCompany> findAllSlice(Pageable pageable);
}
