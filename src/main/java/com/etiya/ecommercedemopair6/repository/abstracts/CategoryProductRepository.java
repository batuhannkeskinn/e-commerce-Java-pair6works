package com.etiya.ecommercedemopair6.repository.abstracts;


import com.etiya.ecommercedemopair6.entities.concretes.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryProductRepository extends JpaRepository<CategoryProduct, Integer> {

}
