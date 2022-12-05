package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.category.CreateCategoryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.category.CreateCategoryResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Category;
import com.etiya.ecommercedemopair6.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(int id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Category> getAllCategoriesNameDesc(String name) {
        return categoryRepository.findAllCategoriesByCategoryName(name);
    }

    @Override
    public Category customFindName(int id) {
        return categoryRepository.customByName(id);
    }

    @Override
    public CreateCategoryResponse createCategory(CreateCategoryRequest createCategoryRequest) {
        Category category = new Category();
        category.setCategoryName(createCategoryRequest.getCategoryName());
        category.setDescription(createCategoryRequest.getDescription());
        Category savedCategory= categoryRepository.save(category);
        CreateCategoryResponse response = new CreateCategoryResponse(category.getCategoryName(), category.getDescription());
        return response;

    }

}
