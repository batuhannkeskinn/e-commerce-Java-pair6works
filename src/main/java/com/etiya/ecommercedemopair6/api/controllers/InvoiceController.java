package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.InvoiceService;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.invoice.GetAllInvoiceResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.core.util.result.SuccessResult;
import com.etiya.ecommercedemopair6.entities.concretes.Invoice;
import com.etiya.ecommercedemopair6.entities.concretes.Supplier;
import lombok.AllArgsConstructor;
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
@RequestMapping(name = "/api/invoices")
public class InvoiceController {
    private InvoiceService invoiceService;

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<GetAllInvoiceResponse>>> getAllInvoices(){
        return new ResponseEntity<DataResult<List<GetAllInvoiceResponse>>>(invoiceService.getAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getInvoicePages")
    public ResponseEntity<DataResult<Page<Invoice>>>getInvoicePages (@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return  new ResponseEntity<>(invoiceService.findAll(pageable),HttpStatus.OK);
    }
    @GetMapping("/getInvoiceSlies")
    public ResponseEntity<DataResult<Slice<Invoice>>> getInvoiceSlice(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return new ResponseEntity<>(invoiceService.findAllSlice(pageable),HttpStatus.OK);

    }

}
