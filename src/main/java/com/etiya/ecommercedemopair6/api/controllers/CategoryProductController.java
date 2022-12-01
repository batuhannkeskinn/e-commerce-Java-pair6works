package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.CategoryProductService;
import com.etiya.ecommercedemopair6.entities.concretes.CategoryProduct;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/CategoryProducts")
@AllArgsConstructor
public class CategoryProductController {


    private CategoryProductService categoryProductService;

    @GetMapping("/getAll")
    public List<CategoryProduct> getAll() {
        return categoryProductService.getAll();
    }

    @GetMapping("/getById")
    public CategoryProduct getById(@RequestParam int id) {
        return categoryProductService.getById(id);
    }
}
