package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.SizeService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.size.CreateSizeRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.size.CreateSizeResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.size.GetAllSizesResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.size.GetSizeResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemopair6.core.util.result.SuccessResult;
import com.etiya.ecommercedemopair6.entities.concretes.Size;
import com.etiya.ecommercedemopair6.repository.abstracts.SizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SizeManager implements SizeService {
   private SizeRepository sizeRepository;
   private ModelMapperService modelMapperService;
    @Override
    public DataResult<GetSizeResponse> getById(int id) {
        Size size =  sizeRepository.findById(id).orElseThrow();
        GetSizeResponse response = modelMapperService.forResponse().map(size, GetSizeResponse.class);
        return new SuccessDataResult<>(response, Message.Size.getBysizeId);
    }

    @Override
    public DataResult<List<GetAllSizesResponse>> getAllServices() {
        List<Size> sizes = sizeRepository.findAll();
        List<GetAllSizesResponse> responses = sizes.stream().map(size -> modelMapperService.forResponse()
                .map(size, GetAllSizesResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(responses,Message.Size.getAllSizes);
    }

    @Override
    public Result createSize(CreateSizeRequest createSizeRequest) {
//      Size size = new Size();
//      size.setNumber(createSizeRequest.getNumber());
//      Size sizeSaved = sizeRepository.save(size);
//      CreateSizeResponse response = new CreateSizeResponse(sizeSaved.getNumber());

        Size size = modelMapperService.forRequest().map(createSizeRequest,Size.class);
        Size savedSize = sizeRepository.save(size);
        CreateSizeResponse response = modelMapperService.forResponse().map(savedSize,CreateSizeResponse.class);

       return new SuccessResult(Message.Size.createSize);


    }
}
