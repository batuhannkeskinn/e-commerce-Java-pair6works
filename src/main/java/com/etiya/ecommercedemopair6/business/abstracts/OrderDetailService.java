package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.orderDetail.CreateOrderDetailRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.orderDetail.CreateOrderDetailResponse;
import com.etiya.ecommercedemopair6.entities.concretes.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    OrderDetail getById(int id);
    List<OrderDetail> getAllOrderDetails();
    CreateOrderDetailResponse createOrderDetail(CreateOrderDetailRequest createOrderDetailRequest);
}
