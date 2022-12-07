package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.category.CreateCategoryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.category.CreateCategoryResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.entities.concretes.Category;
import com.etiya.ecommercedemopair6.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;
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
        checkIfExistsWithSameName(createCategoryRequest.getCategoryName());
        //***********************************ManuelMapper******************************************

//        Category category = new Category();
//        category.setCategoryName(createCategoryRequest.getCategoryName());
//        category.setDescription(createCategoryRequest.getDescription());
//        Category savedCategory= categoryRepository.save(category);
//        CreateCategoryResponse response = new CreateCategoryResponse(savedCategory.getCategoryName(), savedCategory.getDescription());

        Category category = modelMapperService.forRequest().map(createCategoryRequest,Category.class);
        Category savedCategory=categoryRepository.save(category);
        CreateCategoryResponse response = modelMapperService.forResponse().map(savedCategory,CreateCategoryResponse.class);
        return response;

    }

    public void checkIfExistsWithSameName(String name){
        boolean isExists = categoryRepository.existsCategoryByCategoryName(name);
        if (isExists){
            throw new RuntimeException("Bu kategori mevcut");
        }
    }



//    private void categoryCanNotExistWithSameName(String name){
//        // Exception fırlatma
//        boolean isExists = categoryRepository.existsCategoryByName(name);  //false,true
//        if(isExists) // Veritabanımda bu isimde bir kategori mevcut!!
//            // TODO: Add custom business exception.
//            // TODO: Remove magic string
//            // TODO: Add global exception handler
//            throw new RuntimeException("Bu isimle bir kategori zaten mevcut!");
//    }

}
