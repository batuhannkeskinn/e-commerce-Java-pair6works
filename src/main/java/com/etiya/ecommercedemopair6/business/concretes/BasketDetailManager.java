package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.BasketDetailService;
import com.etiya.ecommercedemopair6.business.abstracts.BasketService;
import com.etiya.ecommercedemopair6.business.abstracts.ProductService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.BasketDetail.CreateBasketDetailRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.basketDetail.CreateBasketDetailResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Basket;
import com.etiya.ecommercedemopair6.entities.concretes.BasketDetail;
import com.etiya.ecommercedemopair6.entities.concretes.Product;
import com.etiya.ecommercedemopair6.repository.abstracts.BasketDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BasketDetailManager implements BasketDetailService {

    private BasketDetailRepository basketDetailRepository;
    private ProductService productService;
    private BasketService basketService;

    @Override
    public BasketDetail getById(int id){
        return basketDetailRepository.findById(id).orElseThrow();

    }

    @Override
    public List<BasketDetail> getAllBasketDetail() {
        return basketDetailRepository.findAll();
    }

    @Override
    public CreateBasketDetailResponse createBasket(CreateBasketDetailRequest createBasketDetailRequest) {
        Product product = productService.getById(createBasketDetailRequest.getProductId());
        Basket basket = basketService.getById(createBasketDetailRequest.getBasketId());
        BasketDetail   basketDetail = new BasketDetail();
        basketDetail.setQuantity(createBasketDetailRequest.getQuantity());
        basketDetail.setBasket(basket);
        basketDetail.setProduct(product);
        BasketDetail savedBasketDetail = basketDetailRepository.save(basketDetail);
        CreateBasketDetailResponse response = new
                CreateBasketDetailResponse(savedBasketDetail.getBasket().getBasketId(),savedBasketDetail.getQuantity(),savedBasketDetail.getProduct().getProductId());
        return response ;
    }


}
