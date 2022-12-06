package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.DeliveryService;
import com.etiya.ecommercedemopair6.business.abstracts.OrderService;
import com.etiya.ecommercedemopair6.business.abstracts.ShippingCompanyService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.delivery.CreateDeliveryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.delivery.CreateDeliveryResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Delivery;
import com.etiya.ecommercedemopair6.entities.concretes.Order;
import com.etiya.ecommercedemopair6.entities.concretes.ShippingCompany;
import com.etiya.ecommercedemopair6.repository.abstracts.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DeliveryManager implements DeliveryService {
    private DeliveryRepository deliveryRepository;
    private ShippingCompanyService shippingCompanyService;
    private OrderService orderService;

    @Override
    public Delivery getById(int id) {
        return deliveryRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Delivery> getAllDelivery() {
        return deliveryRepository.findAll();
    }

    @Override
    public CreateDeliveryResponse createDelivery(CreateDeliveryRequest createDeliveryRequest) {
        ShippingCompany shippingCompany = shippingCompanyService.getById(createDeliveryRequest.getShippingCompanyId());
        Order order = orderService.getById(createDeliveryRequest.getOrderId());
        Delivery delivery = new Delivery();
        delivery.setDeliveryDate(createDeliveryRequest.getDeliveryDate());
        delivery.setShippingCompany(shippingCompany);
        delivery.setOrder(order);
        Delivery savedDelivery = deliveryRepository.save(delivery);
        CreateDeliveryResponse response = new
                CreateDeliveryResponse(
                savedDelivery.getDeliveryDate(),
                savedDelivery.getShippingCompany().getShippingCompanyId(),
                savedDelivery.getOrder().getOrderId());
        return response;

    }
}
