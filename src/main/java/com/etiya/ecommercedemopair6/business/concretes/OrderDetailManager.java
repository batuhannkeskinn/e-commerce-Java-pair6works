package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.OrderDetailService;
import com.etiya.ecommercedemopair6.business.abstracts.OrderService;
import com.etiya.ecommercedemopair6.business.abstracts.ProductService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.orderDetail.CreateOrderDetailRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.orderDetail.CreateOrderDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.orderDetail.GetAllOrderDetailResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.orderDetail.GetOrderDetailResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemopair6.core.util.result.SuccessResult;
import com.etiya.ecommercedemopair6.entities.concretes.OrderDetail;
import com.etiya.ecommercedemopair6.repository.abstracts.OrderDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderDetailManager implements OrderDetailService {

    private OrderDetailRepository orderDetailRepository;
    private OrderService orderService;
    private ProductService productService;
    private ModelMapperService modelMapperService;


    @Override
    public DataResult<GetOrderDetailResponse> getById(int id) {
        OrderDetail orderDetail = orderDetailRepository.findById(id).orElseThrow();
        GetOrderDetailResponse response = modelMapperService.forResponse().map(orderDetail, GetOrderDetailResponse.class);
        return new SuccessDataResult<>(response, Message.OrderDetail.getByOrderDetailId);

    }

    @Override
    public DataResult<List<GetAllOrderDetailResponse>> getAllOrderDetails() {

        List<OrderDetail> orderDetails = orderDetailRepository.findAll();
        List<GetAllOrderDetailResponse> responses = orderDetails.
                stream().map
                        (orderDetail -> modelMapperService.forResponse().map
                                (orderDetail, GetAllOrderDetailResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(responses, Message.OrderDetail.getAllOrderDetails);
    }

    @Override
    public Result createOrderDetail(CreateOrderDetailRequest createOrderDetailRequest) {
        OrderDetail orderDetail = modelMapperService.forRequest().map(createOrderDetailRequest, OrderDetail.class);

        OrderDetail detailSaved = orderDetailRepository.save(orderDetail);
        CreateOrderDetailResponse response = modelMapperService.forResponse().map(detailSaved, CreateOrderDetailResponse.class);

//**************************************ManuelMapper******************************************
        //        Order order = orderService.getById(createOrderDetailRequest.getOrderId());
//        Product product = productService.getById(createOrderDetailRequest.getProductId());
//        OrderDetail orderDetail = new OrderDetail();
//
//        orderDetail.setOrder(order);
//        orderDetail.setProduct(product);
//        OrderDetail savedOrderDetail = orderDetailRepository.save(orderDetail);
//        CreateOrderDetailResponse response = new CreateOrderDetailResponse(
//                savedOrderDetail.getOrder().getOrderId(),
//                savedOrderDetail.getProduct().getProductId());
        return new SuccessResult(Message.OrderDetail.createOrderDetail);
    }

}
