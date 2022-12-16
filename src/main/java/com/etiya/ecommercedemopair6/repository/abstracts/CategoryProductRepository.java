package com.etiya.ecommercedemopair6.repository.abstracts;


import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.Brand;
import com.etiya.ecommercedemopair6.entities.concretes.CategoryProduct;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryProductRepository extends JpaRepository<CategoryProduct, Integer> {
    @Query("Select cp from CategoryProduct as cp")
    Slice<CategoryProduct> findAllSlice(Pageable pageable);
}
