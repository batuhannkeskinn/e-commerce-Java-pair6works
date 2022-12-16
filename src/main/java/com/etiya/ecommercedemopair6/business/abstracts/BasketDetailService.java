package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.BasketDetail.CreateBasketDetailRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.CreateBasketDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.GetAllBasketDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.GetBasketDetailResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.BasketDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface BasketDetailService {
    DataResult<GetBasketDetailResponse> getById(int id);

    DataResult<List<GetAllBasketDetailResponse>> getAllBasketDetail();

    Result createBasket(CreateBasketDetailRequest createBasketDetailRequest);

    DataResult<Page<BasketDetail>> findAll(Pageable pageable);

    DataResult<Slice<BasketDetail>> findAllSlice(Pageable pageable);

}
