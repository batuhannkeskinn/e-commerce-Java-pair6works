package com.etiya.ecommercedemopair6.repository.abstracts;
//bu interface in veri erişim katmanı olması için alması gereken extends

import com.etiya.ecommercedemopair6.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    //stock sayısına göre stock alanı gelen int değerlerden fazla olan productlar
    List<Product> findAllProductsByStockGreaterThan(int stock);
    @Query("Select p from Product as p Where name =:name")
    Product findByName(String name);

}
