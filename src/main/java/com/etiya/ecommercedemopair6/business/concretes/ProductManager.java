package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair6.business.abstracts.ProductService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.product.CreateProductRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.product.CreateProductResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.product.GetAllProductsResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.product.GetProductResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.entities.concretes.Product;
import com.etiya.ecommercedemopair6.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<GetAllProductsResponse> getAll() {
        List<Product> products = productRepository.findAll();
        List<GetAllProductsResponse> responses = products
                .stream().map(product -> modelMapperService.forResponse().map(product,GetAllProductsResponse.class))
                .collect(Collectors.toList());

        return responses;
    }


    @Override
    public GetProductResponse getById(int id) {
        Product product = productRepository.findById(id).orElseThrow();
        GetProductResponse response = modelMapperService.forResponse().map(product,GetProductResponse.class);
        return response;
    }

    @Override
    public List<GetAllProductsResponse> getAllByStockGreaterThan(int stock) {
        List<Product> products =  productRepository.findAllProductsByStockGreaterThan(stock);
        List<GetAllProductsResponse> responses = products.stream()
                .map(product -> modelMapperService.forResponse().map(product,GetAllProductsResponse.class))
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public GetProductResponse findByName(String name) {
        Product product = productRepository.findByName(name);
        GetProductResponse response = modelMapperService.forResponse().map(product,GetProductResponse.class);
        return response;
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






