package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.*;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.productInfo.CreateProductInfoRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.productInfo.CreateProductInfoResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.productInfo.GetAllProductInfosResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.productInfo.GetProductInfoResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemopair6.core.util.result.SuccessResult;
import com.etiya.ecommercedemopair6.entities.concretes.ProductInfo;
import com.etiya.ecommercedemopair6.repository.abstracts.ProductInfoRepository;
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

@Service
@AllArgsConstructor
public class ProductInfoManager implements ProductInfoService {
    private MessageSource messageSource;
    private BrandService brandService;
    private ColorService colorService;
    private SizeService sizeService;
    private ProductService productService;
    private ProductInfoRepository productInfoRepository;
    private ModelMapperService modelMapperService;
    private final ProductRepository productRepository;

    @Override
    public DataResult<GetProductInfoResponse> getById(int id) {
        ProductInfo productInfo = productInfoRepository.findById(id).orElseThrow();
        GetProductInfoResponse response = modelMapperService.forResponse().map(productInfo, GetProductInfoResponse.class);
        return new SuccessDataResult<>(response, messageSource.getMessage(Message.ProductInfo.getByProductInfId,null,
                LocaleContextHolder.getLocale()));


        //return productInfoRepository.findById(id).orElseThrow();
    }

    @Override
    public DataResult<List<GetAllProductInfosResponse>> getAllProductInfos() {
        List<ProductInfo> productInfos = productInfoRepository.findAll();
        List<GetAllProductInfosResponse> responses = productInfos.stream().map
                (productInfo -> modelMapperService.forResponse().map
                        (productInfo, GetAllProductInfosResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(responses, Message.ProductInfo.getAllProductInfos);
    }

    @Override
    public Result createProduct(CreateProductInfoRequest createProductInfoRequest) {
        ProductInfo productInfo = modelMapperService.forRequest().map(createProductInfoRequest, ProductInfo.class);
        ProductInfo savedProductInfo = productInfoRepository.save(productInfo);
        CreateProductInfoResponse response = modelMapperService.forResponse().map(savedProductInfo, CreateProductInfoResponse.class);
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

        return new SuccessResult(Message.ProductInfo.createProductInfo);
    }

    @Override
    public DataResult<Page<ProductInfo>> findAll(Pageable pageable) {
        return new SuccessDataResult<>(productInfoRepository.findAll(pageable), messageSource.getMessage(Message.Address.getAllPageable,null,
                LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Slice<ProductInfo>> findAllSlice(Pageable pageable) {
        return new SuccessDataResult<>(productInfoRepository.findAllSlice(pageable), messageSource.getMessage(Message.Address.getAllPageable,null,
                LocaleContextHolder.getLocale()));
    }
}
