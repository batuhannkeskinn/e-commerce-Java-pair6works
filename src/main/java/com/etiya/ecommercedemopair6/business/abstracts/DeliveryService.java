package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.delivery.CreateDeliveryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.delivery.CreateDeliveryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.delivery.GetAllDeliveryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.delivery.GetDeliveryResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.BasketDetail;
import com.etiya.ecommercedemopair6.entities.concretes.Delivery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface DeliveryService {
    DataResult<GetDeliveryResponse >getById(int id);
    DataResult<List<GetAllDeliveryResponse>> getAllDelivery();
    Result createDelivery(CreateDeliveryRequest createDeliveryRequest);

    DataResult<Page<Delivery>> findAll(Pageable pageable);
    DataResult<Slice<Delivery>> findAllSlice(Pageable pageable);

}
