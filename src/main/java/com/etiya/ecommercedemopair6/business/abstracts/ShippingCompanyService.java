package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.shippingCompany.CreateShippingCompanyRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.shippingCompany.CreateShippingCompanyResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.shippingCompany.GetAllShippingCompanyResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.shippingCompany.GetShippingCompanyResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.BasketDetail;
import com.etiya.ecommercedemopair6.entities.concretes.ShippingCompany;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface ShippingCompanyService {
    DataResult<GetShippingCompanyResponse> getById(int id);
    DataResult<List<GetAllShippingCompanyResponse>>getAllShippingCompanies();
    Result createShippingCompany(CreateShippingCompanyRequest createShippingCompanyRequest);

    DataResult<Page<ShippingCompany>> findAll(Pageable pageable);
    DataResult<Slice<ShippingCompany>> findAllSlice(Pageable pageable);

}
