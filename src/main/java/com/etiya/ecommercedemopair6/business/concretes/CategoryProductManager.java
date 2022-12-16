package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.CategoryProductService;
import com.etiya.ecommercedemopair6.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair6.business.abstracts.ProductService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.categoryProduct.CreateCategoryProductRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.categoryProduct.CreateCategoryProductResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.categoryProduct.GetAllCategoryProductResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.categoryProduct.GetCategoryProductResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemopair6.core.util.result.SuccessResult;
import com.etiya.ecommercedemopair6.entities.concretes.CategoryProduct;
import com.etiya.ecommercedemopair6.repository.abstracts.CategoryProductRepository;
import com.etiya.ecommercedemopair6.repository.abstracts.CategoryRepository;
import com.etiya.ecommercedemopair6.repository.abstracts.PaymentRepository;
import com.etiya.ecommercedemopair6.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryProductManager implements CategoryProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final PaymentRepository paymentRepository;
    private CategoryProductRepository categoryProductRepository;
    private ProductService productService;
    private CategoryService categoryService;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;

    @Override
    public DataResult<List<GetAllCategoryProductResponse>> getAll() {

        List<CategoryProduct> categoryProducts = categoryProductRepository.findAll();
        List<GetAllCategoryProductResponse> responses = categoryProducts.stream().
                map(categoryProduct -> modelMapperService.forResponse().map(categoryProduct, GetAllCategoryProductResponse.class))
                .collect(Collectors.toList());
       // return new SuccessDataResult<>(responses, Message.CategoryProduct.getAllCategoryProducts);
        // return categoryProductRepository.findAll();
        return new SuccessDataResult<>(responses,messageSource.getMessage(Message.CategoryProduct.getAllCategoryProducts,null,
                LocaleContextHolder.getLocale()));
    }


    @Override
    public DataResult<GetCategoryProductResponse> getById(int id) {
        CategoryProduct categoryProduct = categoryProductRepository.findById(id).orElseThrow();
        GetCategoryProductResponse response = modelMapperService.forResponse().map(categoryProduct, GetCategoryProductResponse.class);
       // return new SuccessDataResult<>(response, Message.CategoryProduct.getByCategoryProductId);

        return new SuccessDataResult<>(response,messageSource.getMessage(Message.CategoryProduct.getByCategoryProductId,null,
                LocaleContextHolder.getLocale()));
    }

    @Override
    public Result createCategoryProduct(CreateCategoryProductRequest createCategoryProductRequest) {
        checkIfExistsProductId(createCategoryProductRequest.getProductId());
        checkIfExistsProductId(createCategoryProductRequest.getCategoryId());
//***********************************ManuelMapper******************************************

//        Product product = productService.getById(createCategoryProductRequest.getProductId());
//        Category category = categoryService.getById(createCategoryProductRequest.getProductId());
//        CategoryProduct categoryProduct = new CategoryProduct();
//        categoryProduct.setCategory(category);
//        categoryProduct.setProduct(product);
//        CategoryProduct savedCategoryProduct = categoryProductRepository.save(categoryProduct);
//        CreateCategoryProductResponse response = new
//                CreateCategoryProductResponse(
//                        savedCategoryProduct.getCategory().getCategoryId(),
//                        savedCategoryProduct.getProduct().getProductId());

        CategoryProduct categoryProduct = modelMapperService.forRequest().map(createCategoryProductRequest, CategoryProduct.class);
        CategoryProduct savedCategoryProduct = categoryProductRepository.save(categoryProduct);
        CreateCategoryProductResponse response = modelMapperService.forResponse().map(savedCategoryProduct, CreateCategoryProductResponse.class);
       // return new SuccessResult(Message.CategoryProduct.createCategoryProduct);
        return new SuccessDataResult<>(response,messageSource.getMessage(Message.CategoryProduct.createCategoryProduct,null,
                LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Page<CategoryProduct>> findAll(Pageable pageable) {
        return new SuccessDataResult<>(categoryProductRepository.findAll(pageable),  messageSource.getMessage(Message.Address.getAllPageable,null,
                LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Slice<CategoryProduct>> findAllSlice(Pageable pageable) {
        return new SuccessDataResult<>(categoryProductRepository.findAllSlice(pageable), messageSource.getMessage(Message.Address.getAllPageable,null,
                LocaleContextHolder.getLocale()));
    }

    public void checkIfExistsProductId(int id) {
        boolean isExists = productRepository.existsById(id);
        if (!isExists) {
            throw new RuntimeException(Message.Product.CheckIfExistsProductId);
        }
    }

    public void checkIfExistsCategoryId(int id) {
        boolean isExists = categoryRepository.existsById(id);
        if (!isExists) {
            throw new RuntimeException(Message.Category.CheckIfExistsCategoryId);
        }
    }
}
