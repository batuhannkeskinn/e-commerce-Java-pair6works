package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair6.business.abstracts.ProductService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.product.CreateProductRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.product.CreateProductResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.product.GetAllProductsResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.product.GetProductResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemopair6.core.util.result.SuccessResult;
import com.etiya.ecommercedemopair6.entities.concretes.Product;
import com.etiya.ecommercedemopair6.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    //dependency injection
private MessageSource messageSource;
    private ProductRepository productRepository;
    private CategoryService categoryService;
    private ModelMapperService modelMapperService;
    //Spring IoC (inversion on control?) autowired kullanıldı

    @Override
    public DataResult<List<GetAllProductsResponse>> getAll() {
        List<Product> products = productRepository.findAll();
        List<GetAllProductsResponse> responses = products
                .stream().map(product -> modelMapperService.forResponse().map(product, GetAllProductsResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllProductsResponse>>(responses, Message.Product.getAllProducts);

    }

    @Override
    public DataResult<GetProductResponse> getById(int id) {
        Product product = productRepository.findById(id).orElseThrow();
        GetProductResponse response = modelMapperService.forResponse().map(product, GetProductResponse.class);
        return new SuccessDataResult<>(response, messageSource.getMessage(Message.Product.getByProductId,null,
                LocaleContextHolder.getLocale()));

    }

    @Override
    public DataResult<List<GetAllProductsResponse>> getAllByStockGreaterThan(int stock) {
        List<Product> products = productRepository.findAllProductsByStockGreaterThan(stock);
        List<GetAllProductsResponse> responses = products.stream()
                .map(product -> modelMapperService.forResponse().map(product, GetAllProductsResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(responses, Message.Product.getAllProducts);

    }

    @Override
    public DataResult<GetProductResponse> findByName(String name) {
        Product product = productRepository.findByName(name);
        GetProductResponse response = modelMapperService.forResponse().map(product, GetProductResponse.class);
        return new SuccessDataResult<>(response, Message.Product.getByProductId);

    }

    @Override
    public Result createProduct(CreateProductRequest createProductRequest) {
        //***********************************ManuelMapper******************************************

//        Product product = new Product();
//        product.setName((createProductRequest.getProductName()));
//        product.setUnitPrice(createProductRequest.getUnitPrice());
//        product.setStock(createProductRequest.getStock());

//
//        Product savedProduct = productRepository.save(product);
//        CreateProductResponse response = new CreateProductResponse(savedProduct.getName(),
//                savedProduct.getStock(),savedProduct.getUnitPrice());

        Product product = modelMapperService.forRequest().map(createProductRequest, Product.class);
        Product savedProduct = productRepository.save(product);
        CreateProductResponse response = modelMapperService.forResponse().map(savedProduct, CreateProductResponse.class);
        return new SuccessResult(Message.Product.createProduct);

    }

    @Override
    public DataResult customProductId(int id) {
        Product product = productRepository.customProductId(id);
        GetProductResponse response = modelMapperService.forResponse().map(product, GetProductResponse.class);
        return new SuccessDataResult(Message.Product.getByProductId);
    }

    @Override
    public DataResult customProductId2(int id) {
        Product product = productRepository.customProduct2Id(id);
        GetProductResponse response = modelMapperService.forResponse().map(product, GetProductResponse.class);
        return new SuccessDataResult(Message.Product.getByProductId);
    }

    @Override
    public DataResult<Page<Product>> findAll(Pageable pageable) {
        return new SuccessDataResult<>(productRepository.findAll(pageable));
    }

    @Override
    public DataResult<Slice<Product>> findAllSlice(Pageable pageable) {
        return new SuccessDataResult<>(productRepository.findAllSlice(pageable));

    }
    //Eklenen product muhakkak var olan bir category Id ile eşleşmeli.

}






