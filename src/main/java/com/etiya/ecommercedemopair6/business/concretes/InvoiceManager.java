package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.InvoiceService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.invoice.GetAllInvoiceResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.invoice.GetInvoiceResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemopair6.entities.concretes.Invoice;
import com.etiya.ecommercedemopair6.repository.abstracts.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {

    private InvoiceRepository invoiceRepository;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;
    @Override
    public DataResult<GetInvoiceResponse> getById(int id) {
        Invoice  invoice = invoiceRepository.findById(id).get();

        GetInvoiceResponse response = modelMapperService.forResponse().map(invoice,GetInvoiceResponse.class);

        return new SuccessDataResult<>(response);
    }

    @Override
    public DataResult<List<GetAllInvoiceResponse>> getAll() {
        List<Invoice> invoices = invoiceRepository.findAll();
        List<GetAllInvoiceResponse> responses = invoices.stream().map(invoice -> modelMapperService.forResponse().map(invoice, GetAllInvoiceResponse.class)
                ).collect(Collectors.toList());
        return new SuccessDataResult<>(responses);
    }

    @Override
    public DataResult<Page<Invoice>> findAll(Pageable pageable) {
        return new SuccessDataResult<>(invoiceRepository.findAll(pageable), messageSource.getMessage(Message.Address.getAllPageable,null,
                LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Slice<Invoice>> findAllSlice(Pageable pageable) {
        return new SuccessDataResult<>(invoiceRepository.findAllSlice(pageable), messageSource.getMessage(Message.Address.getAllPageable,null,
                LocaleContextHolder.getLocale()));
    }
}
