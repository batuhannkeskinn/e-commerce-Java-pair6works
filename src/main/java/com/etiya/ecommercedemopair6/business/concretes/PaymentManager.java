package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.OrderService;
import com.etiya.ecommercedemopair6.business.abstracts.PaymentService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.payment.CreatePaymentRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.payment.CreatePaymentResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.entities.concretes.Payment;
import com.etiya.ecommercedemopair6.repository.abstracts.AddressRepository;
import com.etiya.ecommercedemopair6.repository.abstracts.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private PaymentRepository paymentRepository;
    private OrderService orderService;
    private ModelMapperService modelMapperService;
    private final AddressRepository addressRepository;

    @Override
    public Payment getById(int id) {
        return paymentRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Payment> getAllPayments() {

        return paymentRepository.findAll();
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
