package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.order.CreateOrderRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.order.CreateOrderResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.order.GetAllOrderResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.order.GetOrderResponse;

import java.util.List;

public interface OrderService {
    GetOrderResponse getById(int id);
    List<GetAllOrderResponse> getAllOrders();
    CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest);
}
