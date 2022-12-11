package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.DeliveryService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.delivery.CreateDeliveryRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.delivery.CreateDeliveryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.delivery.GetAllDeliveryResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.delivery.GetDeliveryResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
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
}
