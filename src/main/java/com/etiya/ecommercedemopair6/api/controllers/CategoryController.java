package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.category.CreateCategoryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.category.CreateCategoryResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Category;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/getAllCategoriesNameDesc")
    public List<Category> getCategoriesNameDesc(String name){
        return categoryService.getAllCategoriesNameDesc(name);
    }


    @GetMapping("/getByName")
    public Category customByName (@RequestParam int id){return categoryService.customFindName(id);

    }

    @PostMapping("/add")
    public ResponseEntity<CreateCategoryResponse> createCategory(CreateCategoryRequest createCategoryRequest){
        CreateCategoryResponse response = categoryService.createCategory(createCategoryRequest);
        return new ResponseEntity<CreateCategoryResponse>(response,HttpStatus.CREATED);

    }
}