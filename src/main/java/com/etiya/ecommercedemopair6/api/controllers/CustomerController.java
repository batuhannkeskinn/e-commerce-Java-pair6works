package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.customer.CreateCustomerRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.customer.CreateCustomerResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.customer.GetAllCustomersResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.customer.GetCustomerResponse;
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
@RequestMapping(Paths.apiPrefix+"customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<GetAllCustomersResponse>>> getAll() {
        return new ResponseEntity<>(customerService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<DataResult<GetCustomerResponse >>getById(@RequestParam int id) {
        return new ResponseEntity<>(customerService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/getAllCustomersByFirstName")
    public ResponseEntity<DataResult<List<GetAllCustomersResponse>>> getAllCustomersByFirstName(@RequestParam("name") String name) {
        return new ResponseEntity<>(customerService.getAllByFirstName(name),HttpStatus.OK);
    }

    @GetMapping("/getCustomById")
    public ResponseEntity<DataResult<GetCustomerResponse>> getcustomById(@RequestParam int id) {
        return  new ResponseEntity<>(customerService.customById(id),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Result> createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return new ResponseEntity<>(customerService.createCustomer(createCustomerRequest), HttpStatus.CREATED);
    }
}
