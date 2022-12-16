package com.etiya.ecommercedemopair6.business.concretes;


import com.etiya.ecommercedemopair6.business.abstracts.BasketService;
import com.etiya.ecommercedemopair6.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.Basket.CreateBasketRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basket.CreateBasketResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basket.GetAllBasketResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basket.GetBasketResponse;
import com.etiya.ecommercedemopair6.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemopair6.core.util.result.SuccessResult;
import com.etiya.ecommercedemopair6.entities.concretes.Basket;
import com.etiya.ecommercedemopair6.repository.abstracts.BasketRepository;
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
public class BasketManager implements BasketService {
    private BasketRepository basketRepository;
    private CustomerService customerService;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;


    @Override
    public DataResult<GetBasketResponse> getById(int id) {
        Basket basket = basketRepository.findById(id).orElseThrow();
        GetBasketResponse response = modelMapperService.forResponse().map(basket, GetBasketResponse.class);
       // return new SuccessDataResult<GetBasketResponse>(response, Message.Basket.getByBasketId);
        return new SuccessDataResult<>(response,messageSource.getMessage(Message.Basket.getByBasketId,null,
                LocaleContextHolder.getLocale()));

    }

    @Override
    public DataResult<List<GetAllBasketResponse>> getAllBasket() {
        List<Basket> basketResponse = basketRepository.findAll();
        List<GetAllBasketResponse> responses = basketResponse.stream()
                .map(basket -> modelMapperService.forResponse().map(basket, GetAllBasketResponse.class))
                .collect(Collectors.toList());
      //  return new SuccessDataResult<>(responses, Message.Basket.getAllBasket);
        return new SuccessDataResult<>(responses,messageSource.getMessage(Message.Basket.getAllBasket,null,
                LocaleContextHolder.getLocale()));
    }

    @Override
    public Result createBasket(CreateBasketRequest createBasketRequest) {
        //***********************************ManuelMapper******************************************

        //Customer customer = customerService.getById(createBasketRequest.getCustomerId());
        // Basket basket = new Basket();
        //basket.setCustomer(customer);
        // basketRepository.save(basket);
        //CreateBasketResponse response = new CreateBasketResponse(basket.getCustomer().getCustomerId());
        //return response;

        Basket basket = modelMapperService.forRequest().map(createBasketRequest, Basket.class);
        Basket savedBasket = basketRepository.save(basket);
        CreateBasketResponse response = modelMapperService.forResponse().map(savedBasket, CreateBasketResponse.class);
       // return new SuccessResult(Message.Basket.createBasket);
        return new SuccessDataResult<>(response,messageSource.getMessage(Message.Basket.createBasket,null,
                LocaleContextHolder.getLocale()));
    }


    @Override
    public DataResult<Page<Basket>> findAll(Pageable pageable) {
        return new SuccessDataResult<>(basketRepository.findAll(pageable),  messageSource.getMessage(Message.Address.getAllPageable,null,
                LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Slice<Basket>> findAllSlice(Pageable pageable) {
        return new SuccessDataResult<>(basketRepository.findAllSlice(pageable),  messageSource.getMessage(Message.Address.getAllPageable,null,
                LocaleContextHolder.getLocale()));
    }

    public void checkIfExistsBasketId(int id) {
        boolean isExists = basketRepository.existsById(id);
        if (!isExists) {
            throw new BusinessException(Message.Street.runTimeException);
        }
    }
}
