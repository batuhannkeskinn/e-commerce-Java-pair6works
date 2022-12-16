package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair6.business.abstracts.InvoiceService;
import com.etiya.ecommercedemopair6.business.abstracts.OrderService;
import com.etiya.ecommercedemopair6.business.abstracts.ProductService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.order.CreateOrderRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.order.GetAllOrderResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.order.GetOrderResponse;
import com.etiya.ecommercedemopair6.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemopair6.core.util.result.SuccessResult;
import com.etiya.ecommercedemopair6.entities.concretes.*;
import com.etiya.ecommercedemopair6.repository.abstracts.*;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class OrderManager implements OrderService {
    private MessageSource messageSource;
    private  InvoiceRepository invoiceRepository;
    private  CustomerRepository customerRepository;
    private  SupplierRepository supplierRepository;
    OrderRepository orderRepository;
    CustomerService customerService;
    OrderDetailRepository orderDetailRepository;
    ProductService productService;
    InvoiceService invoiceService;
    ModelMapperService modelMapperService;
    ProductRepository productRepository;

    @Override
    public DataResult<GetOrderResponse> getById(int id) {
        Order order = orderRepository.findById(id).orElseThrow();
        GetOrderResponse response = modelMapperService.forResponse().map(order, GetOrderResponse.class);
        return new SuccessDataResult<>(response, messageSource.getMessage(Message.Order.getByOrderId,null,
                LocaleContextHolder.getLocale()));


    }

    @Override
    public DataResult<List<GetAllOrderResponse>> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<GetAllOrderResponse> responses = orders.stream().map(order -> modelMapperService.forResponse().map(order, GetAllOrderResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(responses, Message.Order.getAllOrder);
    }

    @Override
    @Transactional
    public Result createOrder(CreateOrderRequest createOrderRequest) {

        //*********************************** Check işlemi**********************************************
        checkIfExistsCustomerId(createOrderRequest.getCustomerId());
        checkIfExistsSupplierId(createOrderRequest.getSupplierId());
        checkIfExistsProductId(createOrderRequest.getProductId());
        //******************************Başlangıç:ihtiyaçlarımı belirle**********************************

        Product product = productRepository.findById(createOrderRequest.getProductId()).get();
        Customer customer = customerRepository.findById(createOrderRequest.getCustomerId()).get();
        Supplier supplier = supplierRepository.findById(createOrderRequest.getSupplierId()).get();


        //*********************************** Total price için hesaplama ******************************************

        double prices = calculateTotalPrice(product, createOrderRequest);

        //******************************** Order için gerekli set işlemleri ******************************************

        Order order = Order.builder()  //orderId:126
                .orderQuantity(createOrderRequest.getOrderQuantity())  //25
                .totalPrice(prices)//50
                .customer(customer).build(); //94
        orderRepository.save(order);
        //********************** Diğer tabloda ki ihtiyaçlarım: get OrderId ihtiyacım için **************************

        Order referanceOrderId = Order.builder().orderId(order.getOrderId()).build(); //126
        //OrderDetail:


        //******************************** OrderDetail ***************************************************************

        OrderDetail detail = OrderDetail.builder()
                .order(referanceOrderId)
                .product(product)
                .supplier(supplier)
                .build();
        orderDetailRepository.save(detail);

        //******************************** OrderDetail ekleme************************************************************

        //İnvoice için set işlemleri manual mapping
//        Invoice invoice = new Invoice();
//        invoice.setInvoiceNumber(UUID.randomUUID().toString());
//        invoice.setProduct(product);
//        invoice.setOrder(order1);

        //******************************** Invoice ekleme ***************************************************************
        Invoice invoice = Invoice.builder()
                .invoiceNumber(UUID.randomUUID().toString())
                .product(product)
                .order(referanceOrderId)
                .build();
        invoiceRepository.save(invoice);
        return new SuccessResult(Message.Order.createOrder);
    }

    @Override
    public DataResult<Page<Order>> findAll(Pageable pageable) {
        return new SuccessDataResult<>(orderRepository.findAll(pageable), messageSource.getMessage(Message.Order.getAllPageable,null,LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Slice<Order>> findAllSlice(Pageable pageable) {
        return new SuccessDataResult<>(orderRepository.findAllSlice(pageable),messageSource.getMessage(Message.Order.getAllPageable,null,LocaleContextHolder.getLocale()));
    }

//******************************** Validation ***************************************************************

    public void checkIfExistsSupplierId(int id) {
        boolean isExists = supplierRepository.existsById(id);
        if (!isExists) {
            throw new BusinessException(messageSource.getMessage(Message.Order.CheckIfExistsOrderId,null,
                    LocaleContextHolder.getLocale()));
        }
    }


    public void checkIfExistsProductId(int id) {
        boolean isExists = productRepository.existsById(id);
        if (!isExists) {
            throw new BusinessException(Message.Product.runTimeException);
        }
    }


    public void checkIfExistsCustomerId(int id) {
        boolean isExists = customerRepository.existsById(id);
        if (!isExists) {
            throw new BusinessException(Message.Customer.runTimeException);
        }
    }

    public double calculateTotalPrice(Product product, CreateOrderRequest order) {
        double total = product.getUnitPrice() * order.getOrderQuantity();
        return total;
    }

}







