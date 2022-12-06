package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.customer.CreateCustomerRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.customer.CreateCustomerResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAll")
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/getById")
    public Customer getById(@RequestParam int id) {
        return customerService.getById(id);
    }

    @GetMapping("/getAllCustomersByFirstName")
    public List<Customer> getAllCustomersByFirstName(@RequestParam("name") String name) {
        return customerService.getAllByFirstName(name);
    }

    @GetMapping("/getCustomById")
    public Customer getcustomById(@RequestParam int id) {
        return customerService.customById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<CreateCustomerResponse> createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return new ResponseEntity<CreateCustomerResponse>(customerService.createCustomer(createCustomerRequest), HttpStatus.CREATED);
    }
}
