package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.SizeService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.size.CreateSizeRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.size.CreateSizeResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.size.GetAllSizesResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.size.GetSizeResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Basket;
import com.etiya.ecommercedemopair6.entities.concretes.Size;
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
@RequestMapping(Paths.apiPrefix+"size")
public class SizeController {
    @Autowired
    private SizeService sizeService;


    @GetMapping("/getById")

    public ResponseEntity<DataResult<GetSizeResponse> >getById(int id) {

     return  new ResponseEntity<>(sizeService.getById(id),HttpStatus.OK) ;
    }

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<GetAllSizesResponse>> >getAllSizes(){
        return new ResponseEntity<>(sizeService.getAllServices(),HttpStatus.OK);
    }


     @PostMapping("/add")
     public ResponseEntity<Result> createSize(CreateSizeRequest createSizeRequest){
        return new ResponseEntity<>(sizeService.createSize(createSizeRequest), HttpStatus.CREATED);
    }
    @GetMapping("/getSizePages")
    public ResponseEntity<DataResult<Page<Size>>>getSizePages (@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return new ResponseEntity<>(sizeService.findAll(pageable),HttpStatus.OK);
    }
    @GetMapping("/getSizeSlies")
    public ResponseEntity<DataResult<Slice<Size>>> getSizeSlies(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return new ResponseEntity<>(sizeService.findAllSlice(pageable),HttpStatus.OK);
    }
}
