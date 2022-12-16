package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.customer.CreateCustomerRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.customer.CreateCustomerResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.customer.GetAllCustomersResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.customer.GetCustomerResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Customer;
import com.etiya.ecommercedemopair6.entities.concretes.Supplier;
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

    @GetMapping("/getCustomerPages")
    public ResponseEntity<DataResult<Page<Customer>>>getCustomerPages (@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return  new ResponseEntity<>(customerService.findAll(pageable),HttpStatus.OK);
    }
    @GetMapping("/getCustomerSlies")
    public ResponseEntity<DataResult<Slice<Customer>>> getCustomerSlice(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return new ResponseEntity<>(customerService.findAllSlice(pageable),HttpStatus.OK);

    }
}
