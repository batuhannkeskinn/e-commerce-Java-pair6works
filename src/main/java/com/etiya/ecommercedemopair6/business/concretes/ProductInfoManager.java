package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.*;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.productInfo.CreateProductInfoRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.productInfo.CreateProductInfoResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.productInfo.GetAllProductInfosResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.productInfo.GetProductInfoResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.entities.concretes.*;
import com.etiya.ecommercedemopair6.repository.abstracts.ProductInfoRepository;
import com.etiya.ecommercedemopair6.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductInfoManager implements ProductInfoService {
    private BrandService brandService;
    private ColorService colorService;
    private SizeService sizeService;
    private ProductService productService;
    private ProductInfoRepository productInfoRepository;
    private ModelMapperService modelMapperService;
    private final ProductRepository productRepository;

    @Override
    public GetProductInfoResponse getById(int id) {
        ProductInfo productInfo=productInfoRepository.findById(id).orElseThrow();
        GetProductInfoResponse response=modelMapperService.forResponse().map(productInfo,GetProductInfoResponse.class);
        return response;


        //return productInfoRepository.findById(id).orElseThrow();
    }

    @Override
    public List<GetAllProductInfosResponse> getAllProductInfos() {

        List<ProductInfo> productInfos = productInfoRepository.findAll();
        List<GetAllProductInfosResponse> responses = productInfos.stream().map
                (productInfo -> modelMapperService.forResponse().map
                        (productInfo, GetAllProductInfosResponse.class)).collect(Collectors.toList());
        return responses;
    }

    @Override
    public CreateProductInfoResponse createProduct2(CreateProductInfoRequest createProductInfoRequest) {
        ProductInfo productInfo = modelMapperService.forRequest().map(createProductInfoRequest,ProductInfo.class);
        ProductInfo savedProductInfo = productInfoRepository.save(productInfo);
        CreateProductInfoResponse response = modelMapperService.forResponse().map(savedProductInfo,CreateProductInfoResponse.class);
// //***********************************ManuelMapper******************************************
//        Brand brand = brandService.getById(createProductInfoRequest.getBrandId());
//        Color color = colorService.getById(createProductInfoRequest.getColorId());
//        Size size = sizeService.getById(createProductInfoRequest.getProductId());
//        Product product = productService.getById(createProductInfoRequest.getProductId());
//
//        ProductInfo productInfo = new ProductInfo();
//        productInfo.setBrand(brand);
//        productInfo.setColor(color);
//        productInfo.setSize(size);
//        productInfo.setProduct(product);
//        ProductInfo savedProductInfo = productInfoRepository.save(productInfo);
//        CreateProductInfoResponse response = new
//                CreateProductInfoResponse
//                (savedProductInfo.getBrand().getBrandId(),
//                        savedProductInfo.getColor().getColorId(),
//                        savedProductInfo.getProduct().getProductId(),
//                        savedProductInfo.getSize().getSizeId());

        return response;
    }
}
