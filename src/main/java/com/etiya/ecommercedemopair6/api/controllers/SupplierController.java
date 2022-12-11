package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.SupplierService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.supplier.CreateSupplierRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.supplier.CreateSupplierResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.supplier.GetAllSupplierResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.supplier.GetSupplierResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"supplier")
@AllArgsConstructor
public class SupplierController {

    private SupplierService supplierService;

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<GetAllSupplierResponse>>>getAll(){

        return new ResponseEntity<>(supplierService.getAll(),HttpStatus.OK);
    }
    @GetMapping("/getById")
    public ResponseEntity<DataResult<GetSupplierResponse>> getById(@RequestParam int id) {
        return new ResponseEntity<>(supplierService.getById(id),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Result> createSupplier(@RequestBody CreateSupplierRequest createSupplierRequest){
        var response = supplierService.createSupplier(createSupplierRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
