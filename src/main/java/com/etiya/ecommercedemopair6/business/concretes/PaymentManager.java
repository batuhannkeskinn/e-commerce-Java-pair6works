package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.OrderService;
import com.etiya.ecommercedemopair6.business.abstracts.PaymentService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.payment.CreatePaymentRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.payment.CreatePaymentResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.payment.GetAllPaymentsResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.payment.GetPaymentResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.entities.concretes.Payment;
import com.etiya.ecommercedemopair6.repository.abstracts.AddressRepository;
import com.etiya.ecommercedemopair6.repository.abstracts.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private PaymentRepository paymentRepository;
    private OrderService orderService;
    private ModelMapperService modelMapperService;
    private final AddressRepository addressRepository;

    @Override
    public GetPaymentResponse getById(int id) {
        Payment payment = paymentRepository.findById(id).orElseThrow();
        GetPaymentResponse response = modelMapperService.forResponse().map(payment,GetPaymentResponse.class);
        return response;
    }

    @Override
    public List<GetAllPaymentsResponse> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        List<GetAllPaymentsResponse> responses = payments.
                stream().map
                        (payment -> modelMapperService.forResponse().map
                                (payment, GetAllPaymentsResponse.class))
                .collect(Collectors.toList());
        return responses;

    }

    @Override
    public CreatePaymentResponse createPayment(CreatePaymentRequest createPaymentRequest) {
//***********************************ManuelMapper******************************************
        Payment payment = modelMapperService.forRequest().map(createPaymentRequest,Payment.class);
        Payment savedPayment = paymentRepository.save(payment);
        CreatePaymentResponse response = modelMapperService.forResponse().map(savedPayment , CreatePaymentResponse.class);
        //        Order order = orderService.getById(createPaymentRequest.getOrderId());
//        Payment payment = new Payment();
//        payment.setBankName(createPaymentRequest.getBankName());
//        payment.setCardNumber(createPaymentRequest.getCardNumber());
//        payment.setOrder(order);
//        Payment savedPayment = paymentRepository.save(payment);
//        CreatePaymentResponse response = new CreatePaymentResponse(savedPayment.getBankName(),
//                savedPayment.getCardNumber(), savedPayment.getOrder().getOrderId());
        return response;
    }
}
