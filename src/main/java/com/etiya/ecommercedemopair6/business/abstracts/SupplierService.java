package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.supplier.CreateSupplierRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.supplier.CreateSupplierResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.supplier.GetAllSupplierResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.supplier.GetSupplierResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;

import java.util.List;

public interface SupplierService {

   DataResult<GetSupplierResponse>getById(int id);
   DataResult<List<GetAllSupplierResponse>>getAll();
   Result createSupplier (CreateSupplierRequest createSupplierRequest);





}
