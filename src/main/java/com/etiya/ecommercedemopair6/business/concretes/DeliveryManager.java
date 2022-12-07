package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.DeliveryService;
import com.etiya.ecommercedemopair6.business.abstracts.OrderService;
import com.etiya.ecommercedemopair6.business.abstracts.ShippingCompanyService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.delivery.CreateDeliveryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.delivery.CreateDeliveryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.delivery.GetAllDeliveryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.delivery.GetDeliveryResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.entities.concretes.Delivery;
import com.etiya.ecommercedemopair6.repository.abstracts.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DeliveryManager implements DeliveryService {
    private DeliveryRepository deliveryRepository;
    private ShippingCompanyService shippingCompanyService;
    private OrderService orderService;
    private ModelMapperService modelMapperService;

    @Override
    public GetDeliveryResponse getById(int id) {
    Delivery delivery = deliveryRepository.findById(id).orElseThrow();
    GetDeliveryResponse response = modelMapperService.forResponse().map(delivery,GetDeliveryResponse.class);
    return response;
    }

    @Override
    public List<GetAllDeliveryResponse> getAllDelivery() {
        List<Delivery> deliveries = deliveryRepository.findAll();
        List<GetAllDeliveryResponse> responses = deliveries.stream().map(delivery -> modelMapperService.forResponse().map(delivery,GetAllDeliveryResponse.class)).collect(Collectors.toList());
        return responses;
    }

    @Override
    public CreateDeliveryResponse createDelivery(CreateDeliveryRequest createDeliveryRequest) {
        Delivery delivery = modelMapperService.forRequest().map(createDeliveryRequest,Delivery.class);
        Delivery deliverySaved = deliveryRepository.save(delivery);
        CreateDeliveryResponse response = modelMapperService.forResponse().map(deliverySaved,CreateDeliveryResponse.class);
        //***********************************ManuelMapper******************************************

//        ShippingCompany shippingCompany = shippingCompanyService.getById(createDeliveryRequest.getShippingCompanyId());
//        Order order = orderService.getById(createDeliveryRequest.getOrderId());
//        Delivery delivery = new Delivery();
//        delivery.setDeliveryDate(createDeliveryRequest.getDeliveryDate());
//        delivery.setShippingCompany(shippingCompany);
//        delivery.setOrder(order);
//        Delivery savedDelivery = deliveryRepository.save(delivery);
//        CreateDeliveryResponse response = new
//                CreateDeliveryResponse(
//                savedDelivery.getDeliveryDate(),
//                savedDelivery.getShippingCompany().getShippingCompanyId(),
//                savedDelivery.getOrder().getOrderId());
        return response;

    }
}
