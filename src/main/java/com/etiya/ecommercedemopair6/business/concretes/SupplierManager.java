package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.SupplierService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.supplier.CreateSupplierRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.supplier.CreateSupplierResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.supplier.GetAllSupplierResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.supplier.GetSupplierResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.entities.concretes.Supplier;
import com.etiya.ecommercedemopair6.repository.abstracts.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SupplierManager implements SupplierService {
    ModelMapperService modelMapperService;
    SupplierRepository supplierRepository;

    @Override
    public GetSupplierResponse getById(int id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow();
        GetSupplierResponse response = modelMapperService.forResponse().map(supplier, GetSupplierResponse.class);
        return response;
    }

    @Override
    public List<GetAllSupplierResponse> getAll() {
        List<Supplier> suppliers = supplierRepository.findAll();
        List<GetAllSupplierResponse> responses = suppliers.stream().map(supplier -> modelMapperService.forResponse().map(supplier,
                GetAllSupplierResponse.class)).collect(Collectors.toList());
        return responses;

    }

    @Override
    public CreateSupplierResponse createSupplier(CreateSupplierRequest createSupplierRequest) {
        Supplier supplier = modelMapperService.forRequest().map(createSupplierRequest, Supplier.class);
        Supplier savedSupplier = supplierRepository.save(supplier);
        CreateSupplierResponse response = modelMapperService
                .forResponse().map(savedSupplier, CreateSupplierResponse.class);
        return response;
    }
}
