package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.response.concretes.invoice.GetAllInvoiceResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.invoice.GetInvoiceResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;

import java.util.List;

public interface InvoiceService {
    DataResult<GetInvoiceResponse> getById(int id);
    DataResult<List<GetAllInvoiceResponse>> getAll();
}
