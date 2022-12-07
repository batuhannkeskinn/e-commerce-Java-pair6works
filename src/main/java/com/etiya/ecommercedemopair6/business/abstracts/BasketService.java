package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.Basket.CreateBasketRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basket.CreateBasketResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basket.GetAllBasketResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basket.GetBasketResponse;

import java.util.List;

public interface BasketService {
    GetBasketResponse getById(int id);
    List<GetAllBasketResponse> getAllBasket();
    CreateBasketResponse createBasket(CreateBasketRequest createBasketRequest);
}
