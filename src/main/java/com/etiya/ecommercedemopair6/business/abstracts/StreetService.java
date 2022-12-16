package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.street.CreateStreetRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.street.CreateStreetResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.street.GetAllStreetsResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.street.GetStreetResponse;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.BasketDetail;
import com.etiya.ecommercedemopair6.entities.concretes.Category;
import com.etiya.ecommercedemopair6.entities.concretes.Street;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface StreetService {
   DataResult<GetStreetResponse>  getById(int id);
   DataResult<List<GetAllStreetsResponse>>getAllServices();
   Result createStreet(CreateStreetRequest createStreetRequest);

   DataResult<Page<Street>>findAll(Pageable pageable);
   DataResult<Slice<Street>> findAllSlice(Pageable pageable);

}
