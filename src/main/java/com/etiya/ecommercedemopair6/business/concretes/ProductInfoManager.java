package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.*;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.productInfo.CreateProductInfoRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.productInfo.CreateProductInfoResponse;
import com.etiya.ecommercedemopair6.entities.concretes.*;
import com.etiya.ecommercedemopair6.repository.abstracts.ProductInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductInfoManager implements ProductInfoService {
    private BrandService brandService;
    private ColorService colorService;
    private SizeService sizeService;
    private ProductService productService;
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo getById(int id) {
        return productInfoRepository.findById(id).orElseThrow();    }

    @Override
    public List<ProductInfo> getAllProductInfos() {
        return productInfoRepository.findAll();
    }

    @Override
    public CreateProductInfoResponse createProduct2(CreateProductInfoRequest createProductInfoRequest) {
        Brand brand = brandService.getById(createProductInfoRequest.getBrandId());
        Color color = colorService.getById(createProductInfoRequest.getColorId());
        Size size = sizeService.getById(createProductInfoRequest.getProductId());
        Product product = productService.getById(createProductInfoRequest.getProductId());

        ProductInfo productInfo = new ProductInfo();
        productInfo.setBrand(brand);
        productInfo.setColor(color);
        productInfo.setSize(size);
        productInfo.setProduct(product);
        ProductInfo savedProductInfo = productInfoRepository.save(productInfo);
        CreateProductInfoResponse response = new
                CreateProductInfoResponse
                (savedProductInfo.getBrand().getBrandId(),
                        savedProductInfo.getColor().getColorId(),
                        savedProductInfo.getProduct().getProductId(),
                        savedProductInfo.getSize().getSizeId());

        return response;
    }
}
