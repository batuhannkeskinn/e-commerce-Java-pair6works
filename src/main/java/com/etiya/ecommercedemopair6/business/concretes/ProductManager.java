package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair6.business.abstracts.ProductService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.product.CreateProductRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.product.CreateProductResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.entities.concretes.Product;
import com.etiya.ecommercedemopair6.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//?
@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    //dependency injection

    private ProductRepository productRepository;
    private CategoryService categoryService;
    private ModelMapperService modelMapperService;
    //Spring IoC (inversion on control?) autowired kullanıldı

    @Override
    public List<Product> getAll() {

        return productRepository.findAll();

    }


    @Override
    public Product getById(int id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Product> getAllByStockGreaterThan(int stock) {
        return productRepository.findAllProductsByStockGreaterThan(stock);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public CreateProductResponse createProduct(CreateProductRequest createProductRequest) {
        //***********************************ManuelMapper******************************************

//        Product product = new Product();
//        product.setName((createProductRequest.getProductName()));
//        product.setUnitPrice(createProductRequest.getUnitPrice());
//        product.setStock(createProductRequest.getStock());

//
//        Product savedProduct = productRepository.save(product);
//        CreateProductResponse response = new CreateProductResponse(savedProduct.getName(),
//                savedProduct.getStock(),savedProduct.getUnitPrice());

        Product product = modelMapperService.forRequest().map(createProductRequest,Product.class);
        Product savedProduct = productRepository.save(product);
        CreateProductResponse response = modelMapperService.forResponse().map(savedProduct,CreateProductResponse.class);
        return response;
    }
    //Eklenen product muhakkak var olan bir category Id ile eşleşmeli.


    }






