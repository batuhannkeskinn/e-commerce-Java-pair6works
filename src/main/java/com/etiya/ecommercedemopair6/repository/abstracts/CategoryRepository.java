package com.etiya.ecommercedemopair6.repository.abstracts;

import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findAllCategoriesByCategoryName(String name);

    boolean existsCategoryByCategoryName(String name);


    //    @Query("Select ad from Address as ad Where name =:name")
//    Product findByName(String name);
    @Query("Select ca from Category as ca where category_id =:id")
    Category customByName(int id);

    @Query("Select ct from Category as ct")
    Slice<Category> findAllSlice(Pageable pageable);

}