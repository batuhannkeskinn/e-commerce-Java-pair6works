package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.response.concretes.invoice.GetAllInvoiceResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.invoice.GetInvoiceResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.BasketDetail;
import com.etiya.ecommercedemopair6.entities.concretes.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface InvoiceService {
    DataResult<GetInvoiceResponse> getById(int id);
    DataResult<List<GetAllInvoiceResponse>> getAll();

    DataResult<Page<Invoice>> findAll(Pageable pageable);
    DataResult<Slice<Invoice>> findAllSlice(Pageable pageable);

}
