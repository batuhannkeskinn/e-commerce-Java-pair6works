package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.category.CreateCategoryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.category.CreateCategoryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.category.GetAllCategoryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.category.GetCategoryResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.entities.concretes.Category;
import com.etiya.ecommercedemopair6.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllCategoryResponse> getAll() {
        List<Category> categories  = categoryRepository.findAll();
        List<GetAllCategoryResponse> responses = categories
                .stream()
                .map(category -> modelMapperService.forResponse().map(category,GetAllCategoryResponse.class))
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public GetCategoryResponse getById(int id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        GetCategoryResponse response = modelMapperService.forResponse().map(category,GetCategoryResponse.class);
        return response;
    }

    @Override
    public List<GetAllCategoryResponse> getAllCategoriesNameDesc(String name) {
        List<Category> categories  =categoryRepository.findAllCategoriesByCategoryName(name);
        List<GetAllCategoryResponse> responses = categories
                .stream()
                .map(category -> modelMapperService.forResponse().map(category,GetAllCategoryResponse.class))
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public GetCategoryResponse customFindName(int id) {
        Category category =categoryRepository.customByName(id);
        GetCategoryResponse response = modelMapperService.forResponse().map(category,GetCategoryResponse.class);
        return response;
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
            throw new RuntimeException(Message.Category.CheckIfExistsCategoryId);
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
