package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.OrderDetailService;
import com.etiya.ecommercedemopair6.business.abstracts.OrderService;
import com.etiya.ecommercedemopair6.business.abstracts.ProductService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.orderDetail.CreateOrderDetailRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.orderDetail.CreateOrderDetailResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Order;
import com.etiya.ecommercedemopair6.entities.concretes.OrderDetail;
import com.etiya.ecommercedemopair6.entities.concretes.Product;
import com.etiya.ecommercedemopair6.repository.abstracts.OrderDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderDetailManager implements OrderDetailService {

    private OrderDetailRepository orderDetailRepository;
    private OrderService orderService;
    private ProductService productService;


    @Override
    public OrderDetail getById(int id) {
        return orderDetailRepository.findById(id).orElseThrow();
    }

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    @Override
    public CreateOrderDetailResponse createOrderDetail(CreateOrderDetailRequest createOrderDetailRequest) {
        Order order = orderService.getById(createOrderDetailRequest.getOrderId());
        Product product = productService.getById(createOrderDetailRequest.getProductId());
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder(order);
        orderDetail.setProduct(product);
        OrderDetail savedOrderDetail = orderDetailRepository.save(orderDetail);
        CreateOrderDetailResponse response = new CreateOrderDetailResponse(
                savedOrderDetail.getOrder().getOrderId(),
                savedOrderDetail.getProduct().getProductId());
        return response;
    }

}
