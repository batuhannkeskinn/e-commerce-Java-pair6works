package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.Basket.CreateBasketRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basket.CreateBasketResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basket.GetAllBasketResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basket.GetBasketResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.Basket;
import com.etiya.ecommercedemopair6.entities.concretes.BasketDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface BasketService {
    DataResult<GetBasketResponse >getById(int id);
    DataResult<List<GetAllBasketResponse>> getAllBasket();
    Result createBasket(CreateBasketRequest createBasketRequest);

    DataResult<Page<Basket>> findAll(Pageable pageable);

    DataResult<Slice<Basket>> findAllSlice(Pageable pageable);
}
