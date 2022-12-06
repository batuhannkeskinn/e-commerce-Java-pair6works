package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair6.business.abstracts.OrderService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.order.CreateOrderRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.order.CreateOrderResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Customer;
import com.etiya.ecommercedemopair6.entities.concretes.Order;
import com.etiya.ecommercedemopair6.repository.abstracts.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class OrderManager implements OrderService {
    OrderRepository orderRepository;
    CustomerService customerService;

    @Override
    public Order getById(int id) {
        return orderRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest) {
        Customer customer = customerService.getById(createOrderRequest.getCustomerId());
        Order order = new Order();
        order.setOrderDate(createOrderRequest.getOrderDate());
        order.setOrderNumber(createOrderRequest.getOrderNumber());
        order.setOrderQuantity(createOrderRequest.getOrderQuantity());
        order.setTotalPrice(createOrderRequest.getTotalPrice());
        order.setOrderNumber(createOrderRequest.getOrderNumber());
        order.setCustomer(customer);
        Order savedOrder = orderRepository.save(order);
        CreateOrderResponse response = new CreateOrderResponse(savedOrder.getOrderNumber(),
                savedOrder.getOrderQuantity(), savedOrder.getTotalPrice() , savedOrder.getCustomer().getCustomerId());
        return response;

    }
}
