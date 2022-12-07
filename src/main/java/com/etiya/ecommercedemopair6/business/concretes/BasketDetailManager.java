package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.BasketDetailService;
import com.etiya.ecommercedemopair6.business.abstracts.BasketService;
import com.etiya.ecommercedemopair6.business.abstracts.ProductService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.BasketDetail.CreateBasketDetailRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.CreateBasketDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.GetAllBasketDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.GetBasketDetailResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.entities.concretes.BasketDetail;
import com.etiya.ecommercedemopair6.repository.abstracts.BasketDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BasketDetailManager implements BasketDetailService {

    private BasketDetailRepository basketDetailRepository;
    private ProductService productService;
    private BasketService basketService;
    private ModelMapperService modelMapperService;

    @Override
    public GetBasketDetailResponse getById(int id){
        BasketDetail basketDetail = basketDetailRepository.findById(id).orElseThrow();
        GetBasketDetailResponse response = modelMapperService.forResponse().map(basketDetail,GetBasketDetailResponse.class);
        return response;

    }

    @Override
    public List<GetAllBasketDetailResponse> getAllBasketDetail() {
        List<BasketDetail> basketResponses = basketDetailRepository.findAll();
        List<GetAllBasketDetailResponse> responses = basketResponses.stream()
                .map(basketDetail -> modelMapperService.forResponse().map(basketDetail,GetAllBasketDetailResponse.class))
                .collect(Collectors.toList());


        return responses;
    }

    @Override
    public CreateBasketDetailResponse createBasket(CreateBasketDetailRequest createBasketDetailRequest) {
//***********************************ManuelMapper******************************************


        //Product product = productService.getById(createBasketDetailRequest.getProductId());
        //Basket basket = basketService.getById(createBasketDetailRequest.getBasketId());
        //BasketDetail   basketDetail = new BasketDetail();
        // basketDetail.setQuantity(createBasketDetailRequest.getQuantity());
        // basketDetail.setBasket(basket);
        //basketDetail.setProduct(product);
        //BasketDetail savedBasketDetail = basketDetailRepository.save(basketDetail);

        //Manuall


        BasketDetail basketDetail = modelMapperService.forRequest().map(createBasketDetailRequest, BasketDetail.class);
        BasketDetail savedBasketDetail = basketDetailRepository.save(basketDetail);
        CreateBasketDetailResponse response = modelMapperService.forResponse().map(savedBasketDetail, CreateBasketDetailResponse.class);
        return response;
    }


}
