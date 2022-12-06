package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.DeliveryService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.delivery.CreateDeliveryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.delivery.CreateDeliveryResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Delivery;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/getById")
    public Delivery getById(@RequestParam int id){
        return deliveryService.getById(id);
    }

    @GetMapping("/getAll")
    public List<Delivery> getAllDeliveries(){
        return deliveryService.getAllDelivery();
    }


    @PostMapping("/add")

    public ResponseEntity<CreateDeliveryResponse> createDelivery(CreateDeliveryRequest createDeliveryRequest){
        return new ResponseEntity<CreateDeliveryResponse>(deliveryService.createDelivery(createDeliveryRequest), HttpStatus.CREATED);
    }
}
