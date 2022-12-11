package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.order.CreateOrderRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.order.CreateOrderResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.order.GetAllOrderResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.order.GetOrderResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;

import javax.xml.crypto.Data;
import java.util.List;

public interface OrderService {
    DataResult<GetOrderResponse >getById(int id);
    DataResult<List<GetAllOrderResponse>> getAllOrders();
    Result createOrder(CreateOrderRequest createOrderRequest);
}
