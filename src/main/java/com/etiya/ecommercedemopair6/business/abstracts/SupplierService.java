package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.supplier.CreateSupplierRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.supplier.CreateSupplierResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.supplier.GetAllSupplierResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.supplier.GetSupplierResponse;

import java.util.List;

public interface SupplierService {

    GetSupplierResponse getById(int id);
    List<GetAllSupplierResponse> getAll();
    CreateSupplierResponse createSupplier (CreateSupplierRequest createSupplierRequest);





}
