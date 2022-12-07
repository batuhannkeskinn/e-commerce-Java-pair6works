package com.etiya.ecommercedemopair6;

import com.etiya.ecommercedemopair6.business.concretes.OrderManager;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.Color.CreateColorRequest;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.order.CreateOrderRequest;
import com.etiya.ecommercedemopair6.entities.concretes.Color;
import com.etiya.ecommercedemopair6.entities.concretes.Order;
import com.etiya.ecommercedemopair6.repository.abstracts.ColorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestModelMapper {

    private ModelMapper mapper;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private OrderManager orderManager;

    @BeforeEach
    public void setup() {
        this.mapper = new ModelMapper();
    }

    @Test
    public void whenMapColorWithExactMatch_thenConvertsToDTO() {
        // when similar source object is provided
        Color color =  new Color("sarı");

        CreateColorRequest colorDTO = this.mapper.map(color, CreateColorRequest.class);

        System.out.println("My color is:"+colorDTO.getColorName());
        System.out.println(color.getColorName());
        // then it maps by default

        assertEquals(color.getColorName(), colorDTO.getColorName());
    }

    @Test
    public void whenMapOrderWithExactMatch_thenConvertsToDTO() {
        // when similar source object is provided
        Order order = new Order();
        Date localDateTime = new Date(2022-12-12);

        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        createOrderRequest.setOrderNumber(12121);
        createOrderRequest.setOrderQuantity(146);
        createOrderRequest.setTotalPrice(645);
        createOrderRequest.setCustomerId(90);
        createOrderRequest.setOrderDate(localDateTime);

        Order orderDTO = this.mapper.map(createOrderRequest,Order.class);

        System.out.println("My orderDto is:"+orderDTO.getOrderNumber());
        System.out.println("My orderDto is:"+orderDTO.getTotalPrice());
        System.out.println("My orderDto is:"+orderDTO.getOrderQuantity());
        System.out.println("My orderDto is:"+orderDTO.getCustomer().getCustomerId());

        // then it maps by default
    }
}
