package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.order.CreateOrderRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.order.CreateOrderResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.order.GetAllOrderResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.order.GetOrderResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.BasketDetail;
import com.etiya.ecommercedemopair6.entities.concretes.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import javax.xml.crypto.Data;
import java.util.List;

public interface OrderService {
    DataResult<GetOrderResponse >getById(int id);
    DataResult<List<GetAllOrderResponse>> getAllOrders();
    Result createOrder(CreateOrderRequest createOrderRequest);

    DataResult<Page<Order>> findAll(Pageable pageable);
    DataResult<Slice<Order>> findAllSlice(Pageable pageable);

}
