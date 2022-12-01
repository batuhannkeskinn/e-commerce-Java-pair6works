package com.etiya.ecommercedemopair6.repository.abstracts;

import com.etiya.ecommercedemopair6.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
