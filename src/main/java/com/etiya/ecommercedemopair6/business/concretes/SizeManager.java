package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.SizeService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.size.CreateSizeRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.size.CreateSizeResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Size;
import com.etiya.ecommercedemopair6.repository.abstracts.SizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class SizeManager implements SizeService {
    SizeRepository sizeRepository;
    @Override
    public Size getById(int id) {
        return sizeRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Size> getAllServices() {
        return sizeRepository.findAll();
    }

    @Override
    public CreateSizeResponse createSize(CreateSizeRequest createSizeRequest) {
       Size size = new Size();
       size.setNumber(createSizeRequest.getNumber());
       Size sizeSaved = sizeRepository.save(size);
       CreateSizeResponse response = new CreateSizeResponse(sizeSaved.getNumber());
       return response;




    }
}
