package com.etiya.ecommercedemopair6.repository.abstracts;

import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.ProductInfo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,Integer> {
    @Query("Select pı from ProductInfo as pı")
    Slice<ProductInfo> findAllSlice(Pageable pageable);
}
