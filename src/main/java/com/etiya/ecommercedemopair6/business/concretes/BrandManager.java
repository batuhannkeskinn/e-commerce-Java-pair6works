package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.BrandService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.brand.CreateBrandRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.brand.CreateBrandResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.entities.concretes.Brand;
import com.etiya.ecommercedemopair6.repository.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    @Override
    public Brand getById(int id) {
        return brandRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Brand> getAllBrand() {
        return brandRepository.findAll();
    }

    @Override
    public CreateBrandResponse createBrand(CreateBrandRequest createBrandRequest) {
        //***********************************ManuelMapper******************************************

        //Brand brand=new Brand();
        // brand.setName(createBrandRequest.getName());
        // Brand savedBrand=brandRepository.save(brand);
        // CreateBrandResponse response=new CreateBrandResponse(savedBrand.getName());
        //return response;

        Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        Brand savedBrand = brandRepository.save(brand);
        CreateBrandResponse response = modelMapperService.forResponse().map(savedBrand, CreateBrandResponse.class);
        return response;
    }

}
