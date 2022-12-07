package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.CategoryProductService;
import com.etiya.ecommercedemopair6.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair6.business.abstracts.ProductService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.categoryProduct.CreateCategoryProductRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.categoryProduct.CreateCategoryProductResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Category;
import com.etiya.ecommercedemopair6.entities.concretes.CategoryProduct;
import com.etiya.ecommercedemopair6.entities.concretes.Product;
import com.etiya.ecommercedemopair6.repository.abstracts.CategoryProductRepository;
import com.etiya.ecommercedemopair6.repository.abstracts.CategoryRepository;
import com.etiya.ecommercedemopair6.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class CategoryProductManager implements CategoryProductService {
   private CategoryProductRepository categoryProductRepository;
   private ProductService productService;
   private CategoryService categoryService;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryProduct> getAll() {

        return categoryProductRepository.findAll();
    }

    @Override
    public CategoryProduct getById(int id) {
        return categoryProductRepository.findById(id).orElseThrow();
    }

    @Override
    public CreateCategoryProductResponse createCategoryProduct(CreateCategoryProductRequest createCategoryProductRequest) {
        checkIfExistsProductId(createCategoryProductRequest.getProductId());
        checkIfExistsProductId(createCategoryProductRequest.getCategoryId());











        Product product = productService.getById(createCategoryProductRequest.getProductId());
        Category category = categoryService.getById(createCategoryProductRequest.getProductId());
        CategoryProduct categoryProduct = new CategoryProduct();
        categoryProduct.setCategory(category);
        categoryProduct.setProduct(product);
        CategoryProduct savedCategoryProduct = categoryProductRepository.save(categoryProduct);
        CreateCategoryProductResponse response = new
                CreateCategoryProductResponse(
                        savedCategoryProduct.getCategory().getCategoryId(),
                        savedCategoryProduct.getProduct().getProductId());
        return response;
    }

    public void checkIfExistsProductId(int id){
        boolean isExists = productRepository.existsById(id);
        if (!isExists){
            throw new RuntimeException("This product not found");
        }
    }
    public void checkIfExistsCategoryId(int id){
        boolean isExists = categoryRepository.existsById(id);
        if (!isExists){
            throw new RuntimeException("This category not found");
        }
    }
}
