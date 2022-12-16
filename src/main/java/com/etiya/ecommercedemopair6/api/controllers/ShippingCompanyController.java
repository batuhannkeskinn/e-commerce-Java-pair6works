package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.ShippingCompanyService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.shippingCompany.CreateShippingCompanyRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.shippingCompany.CreateShippingCompanyResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.shippingCompany.GetAllShippingCompanyResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.shippingCompany.GetShippingCompanyResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.ShippingCompany;
import com.etiya.ecommercedemopair6.entities.concretes.Supplier;
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
@RequestMapping(Paths.apiPrefix+"shippingCompanies")
@AllArgsConstructor
public class ShippingCompanyController {
    @Autowired
    private ShippingCompanyService shippingCompanyService;



    @GetMapping("/getById")
    public ResponseEntity<DataResult<GetShippingCompanyResponse>> getById(int id){
        return new ResponseEntity<>(shippingCompanyService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<GetAllShippingCompanyResponse> >> getAll() {
        return new ResponseEntity<>(shippingCompanyService.getAllShippingCompanies(),HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Result> createShippingCompnainy(CreateShippingCompanyRequest createShippingCompanyRequest){
        return new ResponseEntity<>(shippingCompanyService.createShippingCompany(createShippingCompanyRequest), HttpStatus.CREATED);
    }
    @GetMapping("/getShippingCompanyPages")
    public ResponseEntity<DataResult<Page<ShippingCompany>>>getShippingCompanyPages (@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return  new ResponseEntity<>(shippingCompanyService.findAll(pageable),HttpStatus.OK);
    }
    @GetMapping("/getShippingCompanySlies")
    public ResponseEntity<DataResult<Slice<ShippingCompany>>> getShippingCompanySlice(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return new ResponseEntity<>(shippingCompanyService.findAllSlice(pageable),HttpStatus.OK);

    }
}
