package com.etiya.ecommercedemopair6.api.controllers;


import com.etiya.ecommercedemopair6.business.abstracts.StreetService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.street.CreateStreetRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.street.CreateStreetResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.street.GetAllStreetsResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.street.GetStreetResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Basket;
import com.etiya.ecommercedemopair6.entities.concretes.Street;
import com.etiya.ecommercedemopair6.repository.abstracts.StreetRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(Paths.apiPrefix+"street")
public class StreetController {
    @Autowired
    private StreetService streetService;
    @Autowired
    private StreetRepository streetRepository;

    @GetMapping("/getById")
    public ResponseEntity<DataResult<GetStreetResponse>> getById(@RequestParam int id){
        return new ResponseEntity<>(streetService.getById(id),HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<GetAllStreetsResponse>>>getAll(){
        return new ResponseEntity<>(streetService.getAllServices(),HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Result> createStreet(CreateStreetRequest createStreetRequest){
        return new ResponseEntity<>(streetService.createStreet(createStreetRequest), HttpStatus.CREATED);

    }
    @GetMapping("/getStreetPages")
    public ResponseEntity<DataResult<Page<Street>>>getStreetPages (@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return new ResponseEntity<>(streetService.findAll(pageable),HttpStatus.OK);
    }
    @GetMapping("/getStreetSlies")
    public ResponseEntity<DataResult<Slice<Street>>> getBasketSlies(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return new ResponseEntity<>(streetService.findAllSlice(pageable),HttpStatus.OK);

    }

}
