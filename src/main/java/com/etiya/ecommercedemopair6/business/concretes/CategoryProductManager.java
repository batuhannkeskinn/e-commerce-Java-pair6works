package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.CategoryProductService;
import com.etiya.ecommercedemopair6.entities.concretes.CategoryProduct;
import com.etiya.ecommercedemopair6.repository.abstracts.CategoryProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class CategoryProductManager implements CategoryProductService {
   private CategoryProductRepository categoryProductRepository;

    @Override
    public List<CategoryProduct> getAll() {

        return categoryProductRepository.findAll();
    }

    @Override
    public CategoryProduct getById(int id) {
        return categoryProductRepository.findById(id).orElseThrow();
    }
}
