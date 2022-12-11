package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.delivery.CreateDeliveryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.delivery.CreateDeliveryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.delivery.GetAllDeliveryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.delivery.GetDeliveryResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;

import java.util.List;

public interface DeliveryService {
    DataResult<GetDeliveryResponse >getById(int id);
    DataResult<List<GetAllDeliveryResponse>> getAllDelivery();
    Result createDelivery(CreateDeliveryRequest createDeliveryRequest);
}
