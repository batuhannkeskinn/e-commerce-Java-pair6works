package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.BasketDetailService;
import com.etiya.ecommercedemopair6.business.abstracts.BasketService;
import com.etiya.ecommercedemopair6.business.abstracts.ProductService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.BasketDetail.CreateBasketDetailRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.CreateBasketDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.GetAllBasketDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.GetBasketDetailResponse;
import com.etiya.ecommercedemopair6.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemopair6.core.util.result.SuccessResult;
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
    public DataResult<GetBasketDetailResponse> getById(int id){
        BasketDetail basketDetail = basketDetailRepository.findById(id).orElseThrow();
        GetBasketDetailResponse response = modelMapperService.forResponse().map(basketDetail,GetBasketDetailResponse.class);
        return new SuccessDataResult<>(response,Message.BasketDetails.getByBasketDetailId);

    }

    @Override
    public DataResult<List<GetAllBasketDetailResponse>> getAllBasketDetail() {
        List<BasketDetail> basketResponses = basketDetailRepository.findAll();
        List<GetAllBasketDetailResponse> responses = basketResponses.stream()
                .map(basketDetail -> modelMapperService.forResponse().map(basketDetail,GetAllBasketDetailResponse.class))
                .collect(Collectors.toList());


        return new SuccessDataResult<>(responses,Message.BasketDetails.getAllBasketDetails);
    }

    @Override
    public Result createBasket(CreateBasketDetailRequest createBasketDetailRequest) {
        checkIfExistsBasketDetailId(createBasketDetailRequest.getBasketId());

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
        return new SuccessResult(Message.BasketDetails.createBasketDetail);
    }
    public void checkIfExistsBasketDetailId(int id){
        boolean isExists = basketDetailRepository.existsById(id);
        if (!isExists){
            throw new BusinessException(Message.BasketDetails.runTimeException);
        }
    }


}
