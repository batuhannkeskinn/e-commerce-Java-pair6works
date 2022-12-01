package com.etiya.ecommercedemopair6.business.abstracts;
import com.etiya.ecommercedemopair6.entities.concretes.CategoryProduct;

import java.util.List;

public interface CategoryProductService   {
   List<CategoryProduct> getAll();

   CategoryProduct getById(int id);

}
