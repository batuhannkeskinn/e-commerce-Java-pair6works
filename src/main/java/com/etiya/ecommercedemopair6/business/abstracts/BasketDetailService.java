package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.BasketDetail.CreateBasketDetailRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.CreateBasketDetailResponse;
import com.etiya.ecommercedemopair6.entities.concretes.BasketDetail;

import java.util.List;

public interface BasketDetailService {
    BasketDetail getById(int id);

    List<BasketDetail> getAllBasketDetail();

    CreateBasketDetailResponse createBasket(CreateBasketDetailRequest createBasketDetailRequest);

}
