package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.delivery.CreateDeliveryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.delivery.CreateDeliveryResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Delivery;

import java.util.List;

public interface DeliveryService {
    Delivery getById(int id);
    List<Delivery> getAllDelivery();
    CreateDeliveryResponse createDelivery(CreateDeliveryRequest createDeliveryRequest);
}
