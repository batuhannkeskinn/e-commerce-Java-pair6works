package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.delivery.CreateDeliveryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.delivery.CreateDeliveryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.delivery.GetAllDeliveryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.delivery.GetDeliveryResponse;

import java.util.List;

public interface DeliveryService {
    GetDeliveryResponse getById(int id);
    List<GetAllDeliveryResponse> getAllDelivery();
    CreateDeliveryResponse createDelivery(CreateDeliveryRequest createDeliveryRequest);
}
