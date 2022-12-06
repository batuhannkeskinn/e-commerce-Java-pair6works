package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.order.CreateOrderRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.order.CreateOrderResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Order;

import java.util.List;

public interface OrderService {
    Order getById(int id);
    List<Order> getAllOrders();
    CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest);
}
