package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.SupplierService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.supplier.CreateSupplierRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.supplier.CreateSupplierResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.supplier.GetAllSupplierResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.supplier.GetSupplierResponse;
import com.etiya.ecommercedemopair6.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemopair6.core.util.result.SuccessResult;
import com.etiya.ecommercedemopair6.entities.concretes.Order;
import com.etiya.ecommercedemopair6.entities.concretes.Supplier;
import com.etiya.ecommercedemopair6.repository.abstracts.SupplierRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.internal.util.logging.Messages;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SupplierManager implements SupplierService {
    private MessageSource messageSource;
    ModelMapperService modelMapperService;
    SupplierRepository supplierRepository;

    @Override
    public DataResult<GetSupplierResponse> getById(int id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow();
        GetSupplierResponse response = modelMapperService.forResponse().map(supplier, GetSupplierResponse.class);
        return new SuccessDataResult<>(response, Message.Supplier.getBySupplierId);
    }

    @Override
    public DataResult<List<GetAllSupplierResponse>> getAll() {
        List<Supplier> suppliers = supplierRepository.findAll();
        List<GetAllSupplierResponse> responses = suppliers.stream().map(supplier -> modelMapperService.forResponse().map(supplier,
                GetAllSupplierResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(responses, messageSource.getMessage(Message.Supplier.getAllSuppliers,null,
                LocaleContextHolder.getLocale()));
    }

    @Override
    public Result createSupplier(CreateSupplierRequest createSupplierRequest) {
        checkIfExistsSupplierName(createSupplierRequest.getSupplierName());
        Supplier supplier = modelMapperService.forRequest().map(createSupplierRequest, Supplier.class);
        Supplier savedSupplier = supplierRepository.save(supplier);
        CreateSupplierResponse response = modelMapperService
                .forResponse().map(savedSupplier, CreateSupplierResponse.class);
        return new SuccessResult(messageSource.getMessage(Message.Supplier.createSupplier,null
        ,LocaleContextHolder.getLocale()));

    }

    @Override
    public DataResult<Page<Supplier>> findAll(Pageable pageable) {
        return new SuccessDataResult<>(supplierRepository.findAll(pageable),messageSource.getMessage(Message.Supplier
                .getAllPageable,null,LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Slice<Supplier>> findAllSlice(Pageable pageable) {
        return new SuccessDataResult<>(supplierRepository.findAllSlice(pageable),messageSource.getMessage(Message.Supplier
                .getAllPageable,null,LocaleContextHolder.getLocale()));
    }

    private void checkIfExistsSupplierName(String supplerName) {
        boolean isExists = supplierRepository.existsBySupplierName(supplerName);
        if (isExists) {
            throw new BusinessException(messageSource.getMessage(Message.Supplier.CheckIfExistsSizeId,null,LocaleContextHolder.getLocale()));

        }
    }
}
