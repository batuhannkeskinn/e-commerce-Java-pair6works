package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.SupplierService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.supplier.CreateSupplierRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.supplier.CreateSupplierResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.supplier.GetAllSupplierResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.supplier.GetSupplierResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.Supplier;
import com.etiya.ecommercedemopair6.repository.abstracts.SupplierRepository;
import lombok.AllArgsConstructor;
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
@RequestMapping(Paths.apiPrefix+"supplier")
@AllArgsConstructor
public class SupplierController {

    private SupplierService supplierService;
    private final SupplierRepository supplierRepository;

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
    @GetMapping("/getSupplierPages")
    public ResponseEntity<DataResult<Page<Supplier>>>getSupplierPages (@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return  new ResponseEntity<>(supplierService.findAll(pageable),HttpStatus.OK);
    }
    @GetMapping("/getSupplierSlies")
    public ResponseEntity<DataResult<Slice<Supplier>>> getSupplierSlice(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return new ResponseEntity<>(supplierService.findAllSlice(pageable),HttpStatus.OK);

    }
}
