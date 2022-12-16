package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.OrderService;
import com.etiya.ecommercedemopair6.business.abstracts.PaymentService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.payment.CreatePaymentRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.payment.CreatePaymentResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.payment.GetAllPaymentsResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.payment.GetPaymentResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemopair6.core.util.result.SuccessResult;
import com.etiya.ecommercedemopair6.entities.concretes.Payment;
import com.etiya.ecommercedemopair6.repository.abstracts.AddressRepository;
import com.etiya.ecommercedemopair6.repository.abstracts.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private MessageSource messageSource;
    private PaymentRepository paymentRepository;
    private ModelMapperService modelMapperService;


    @Override
    public DataResult<GetPaymentResponse> getById(int id) {
        Payment payment = paymentRepository.findById(id).orElseThrow();
        GetPaymentResponse response = modelMapperService.forResponse().map(payment,GetPaymentResponse.class);
        return new SuccessDataResult<>(response, messageSource.getMessage(Message.Payment.getByPaymentId,null,
                LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<List<GetAllPaymentsResponse>> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        List<GetAllPaymentsResponse> responses = payments.
                stream().map
                        (payment -> modelMapperService.forResponse().map
                                (payment, GetAllPaymentsResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(responses, Message.Payment.getAllPayment);

    }

    @Override
    public Result createPayment(CreatePaymentRequest createPaymentRequest) {
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
        return new SuccessResult(Message.Payment.createPayment);
    }

    @Override
    public DataResult<Page<Payment>> findAll(Pageable pageable) {
        return new SuccessDataResult<>(paymentRepository.findAll(pageable), messageSource.getMessage(Message.Address.getAllPageable,null,
                LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Slice<Payment>> findAllSlice(Pageable pageable) {
        return new SuccessDataResult<>(paymentRepository.findAllSlice(pageable), messageSource.getMessage(Message.Address.getAllPageable,null,
                LocaleContextHolder.getLocale()));
    }

}
