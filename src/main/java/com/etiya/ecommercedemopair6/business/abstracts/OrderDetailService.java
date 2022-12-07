package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.orderDetail.CreateOrderDetailRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.orderDetail.CreateOrderDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.orderDetail.GetAllOrderDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.orderDetail.GetOrderDetailResponse;

import java.util.List;

public interface OrderDetailService {
    GetOrderDetailResponse getById(int id);
    List<GetAllOrderDetailResponse> getAllOrderDetails();
    CreateOrderDetailResponse createOrderDetail(CreateOrderDetailRequest createOrderDetailRequest);
}
