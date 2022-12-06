package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.Basket.CreateBasketRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basket.CreateBasketResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Basket;

import java.util.List;

public interface BasketService {
    Basket getById(int id);
    List<Basket> getAllBasket();
    CreateBasketResponse createBasket(CreateBasketRequest createBasketRequest);
}
