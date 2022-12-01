package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair6.entities.concretes.Category;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

   private CategoryService categoryService;

    @GetMapping("/getAll")
    public List<Category> getAll() {
        return categoryService.getAll();
    }
    @GetMapping("/getById")
    public Category getById(@RequestParam int id) {
        return categoryService.getById(id);
    }

}