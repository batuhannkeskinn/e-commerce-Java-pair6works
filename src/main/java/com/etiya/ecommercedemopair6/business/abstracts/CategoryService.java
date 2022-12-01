package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.entities.concretes.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category getById(int id);
}
