package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.ShippingCompanyService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.shippingCompany.CreateShippingCompanyRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.shippingCompany.CreateShippingCompanyResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.shippingCompany.GetAllShippingCompanyResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.shippingCompany.GetShippingCompanyResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"shippingCompanies")
@AllArgsConstructor
public class ShippingCompanyController {
    @Autowired
    private ShippingCompanyService shippingCompanyService;



    @GetMapping("/getById")
    public GetShippingCompanyResponse getById(int id){
        return shippingCompanyService.getById(id);
    }

    @GetMapping("/getAll")
    public List<GetAllShippingCompanyResponse> getAll() {
        return shippingCompanyService.getAllShippingCompanies();
    }

    @PostMapping("/add")
    public ResponseEntity<CreateShippingCompanyResponse> createShippingCompnainy(CreateShippingCompanyRequest createShippingCompanyRequest){
        return new ResponseEntity<CreateShippingCompanyResponse>(shippingCompanyService.createShippingCompany(createShippingCompanyRequest), HttpStatus.CREATED);
    }
}
