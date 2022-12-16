package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.DeliveryService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.delivery.CreateDeliveryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.delivery.CreateDeliveryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.delivery.GetAllDeliveryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.delivery.GetDeliveryResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Delivery;
import com.etiya.ecommercedemopair6.entities.concretes.Supplier;
import com.etiya.ecommercedemopair6.repository.abstracts.DeliveryRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(Paths.apiPrefix+"deliveries")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private DeliveryRepository deliveryRepository;

    @GetMapping("/getById")
    public ResponseEntity<DataResult<GetDeliveryResponse>> getById(@RequestParam int id){
        return  new ResponseEntity<>(deliveryService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<GetAllDeliveryResponse>>> getAllDeliveries(){
        return new ResponseEntity<>(deliveryService.getAllDelivery(),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Result> createDelivery(CreateDeliveryRequest createDeliveryRequest){
        return new ResponseEntity<>(deliveryService.createDelivery(createDeliveryRequest), HttpStatus.CREATED);
    }
    @GetMapping("/getDeliveryPages")
    public ResponseEntity<DataResult<Page<Delivery>>>getDeliveryPages (@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return  new ResponseEntity<>(deliveryService.findAll(pageable),HttpStatus.OK);
    }
    @GetMapping("/getDeliverySlies")
    public ResponseEntity<DataResult<Slice<Delivery>>> getDeliverySlice(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return new ResponseEntity<>(deliveryService.findAllSlice(pageable),HttpStatus.OK);

    }
}
