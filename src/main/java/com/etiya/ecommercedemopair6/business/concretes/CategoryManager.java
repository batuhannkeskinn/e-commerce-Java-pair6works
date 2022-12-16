package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.category.CreateCategoryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.category.CreateCategoryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.category.GetAllCategoryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.category.GetCategoryResponse;
import com.etiya.ecommercedemopair6.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemopair6.entities.concretes.Category;
import com.etiya.ecommercedemopair6.repository.abstracts.CategoryRepository;
import com.etiya.ecommercedemopair6.repository.abstracts.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private final CountryRepository countryRepository;
    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;

    @Override
    public DataResult<List<GetAllCategoryResponse>> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<GetAllCategoryResponse> responses = categories
                .stream()
                .map(category -> modelMapperService.forResponse().map(category, GetAllCategoryResponse.class))
                .collect(Collectors.toList());
        //return new SuccessDataResult<List<GetAllCategoryResponse>>(responses, Message.Category.getAllCategories);

        return new SuccessDataResult<>(responses,messageSource.getMessage(Message.Category.getAllCategories,null,
                LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<GetCategoryResponse> getById(int id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        GetCategoryResponse response = modelMapperService.forResponse().map(category, GetCategoryResponse.class);
       // return new SuccessDataResult<GetCategoryResponse>(response, Message.Category.getByCategoryId);
        return new SuccessDataResult<>(response,messageSource.getMessage(Message.Category.getByCategoryId,null,
                LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<List<GetAllCategoryResponse>> getAllCategoriesNameDesc(String name) {
        List<Category> categories = categoryRepository.findAllCategoriesByCategoryName(name);
        List<GetAllCategoryResponse> responses = categories
                .stream()
                .map(category -> modelMapperService.forResponse().map(category, GetAllCategoryResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(responses);
    }

    @Override
    public DataResult<GetCategoryResponse> customFindName(int id) {
        Category category = categoryRepository.customByName(id);
        GetCategoryResponse response = modelMapperService.forResponse().map(category, GetCategoryResponse.class);
        return new SuccessDataResult<GetCategoryResponse>(response);
    }

    @Override
    public Result createCategory(CreateCategoryRequest createCategoryRequest) {
        checkIfExistsWithSameName(createCategoryRequest.getCategoryName());
        //***********************************ManuelMapper******************************************

//        Category category = new Category();
//        category.setCategoryName(createCategoryRequest.getCategoryName());
//        category.setDescription(createCategoryRequest.getDescription());
//        Category savedCategory= categoryRepository.save(category);
//        CreateCategoryResponse response = new CreateCategoryResponse(savedCategory.getCategoryName(), savedCategory.getDescription());

        Category category = modelMapperService.forRequest().map(createCategoryRequest, Category.class);
        Category savedCategory = categoryRepository.save(category);
        CreateCategoryResponse response = modelMapperService.forResponse().map(savedCategory, CreateCategoryResponse.class);
       // return new SuccessDataResult(Message.Category.createCategory);
        return new SuccessDataResult<>(response,messageSource.getMessage(Message.Category.createCategory,null,
                LocaleContextHolder.getLocale()));

    }

    @Override
    public DataResult<Page<Category>> findAll(Pageable pageable) {
        return new SuccessDataResult<>(categoryRepository.findAll(pageable),  messageSource.getMessage(Message.Address.getAllPageable,null,
                LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Slice<Category>> findAllSlice(Pageable pageable) {
        return new SuccessDataResult<>(categoryRepository.findAllSlice(pageable), messageSource.getMessage(Message.Address.getAllPageable,null,
                LocaleContextHolder.getLocale()));
    }

    public void checkIfExistsWithSameName(String name) {
        boolean isExists = categoryRepository.existsCategoryByCategoryName(name);
        if (isExists) {
            throw new BusinessException(Message.Category.runTimeException);
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
