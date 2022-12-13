package com.etiya.ecommercedemopair6.api.controllers;

import com.etiya.ecommercedemopair6.business.abstracts.InvoiceService;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.invoice.GetAllInvoiceResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.core.util.result.SuccessResult;
import com.etiya.ecommercedemopair6.entities.concretes.Invoice;
import lombok.AllArgsConstructor;
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

}
