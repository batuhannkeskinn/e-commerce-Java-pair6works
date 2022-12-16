package com.etiya.ecommercedemopair6.api.controllers;


import com.etiya.ecommercedemopair6.business.abstracts.ColorService;
import com.etiya.ecommercedemopair6.business.constants.Paths;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.Color.CreateColorRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.color.CreateColorResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.color.GetAllColorResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.color.GetColorResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Color;
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

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(Paths.apiPrefix+"colors")
public class ColorController {
    @Autowired
    private ColorService colorService;

    @GetMapping("/getById")

    public ResponseEntity<DataResult<GetColorResponse>>getById(@RequestParam int id){
        return new ResponseEntity<DataResult<GetColorResponse>>(colorService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/getAll")

    public ResponseEntity<DataResult<List<GetAllColorResponse>>>getAllColors(){
        return new ResponseEntity<DataResult<List<GetAllColorResponse>>>(colorService.getAllColor(),HttpStatus.OK);
    }

    @PostMapping("/add")

    public ResponseEntity<Result> createColor(@RequestBody @Valid CreateColorRequest createColorRequest){
        return new ResponseEntity<Result>(colorService.createColor(createColorRequest), HttpStatus.CREATED);
    }
    @GetMapping("/getColorPages")
    public ResponseEntity<DataResult<Page<Color>>>getColorPages (@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return  new ResponseEntity<>(colorService.findAll(pageable),HttpStatus.OK);
    }
    @GetMapping("/getColorSlies")
    public ResponseEntity<DataResult<Slice<Color>>> getColorSlice(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return new ResponseEntity<>(colorService.findAllSlice(pageable),HttpStatus.OK);

    }

}
