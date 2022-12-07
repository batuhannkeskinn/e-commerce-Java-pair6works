package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.BasketDetail.CreateBasketDetailRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.CreateBasketDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.GetAllBasketDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.GetBasketDetailResponse;

import java.util.List;

public interface BasketDetailService {
    GetBasketDetailResponse getById(int id);

    List<GetAllBasketDetailResponse> getAllBasketDetail();

    CreateBasketDetailResponse createBasket(CreateBasketDetailRequest createBasketDetailRequest);

}
