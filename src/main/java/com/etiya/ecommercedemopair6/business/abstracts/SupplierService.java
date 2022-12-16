package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.supplier.CreateSupplierRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.supplier.GetAllSupplierResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.supplier.GetSupplierResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.BasketDetail;
import com.etiya.ecommercedemopair6.entities.concretes.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface SupplierService {

    DataResult<GetSupplierResponse> getById(int id);

    DataResult<List<GetAllSupplierResponse>> getAll();

    Result createSupplier(CreateSupplierRequest createSupplierRequest);

    DataResult<Page<Supplier>> findAll(Pageable pageable);
    DataResult<Slice<Supplier>> findAllSlice(Pageable pageable);



}
