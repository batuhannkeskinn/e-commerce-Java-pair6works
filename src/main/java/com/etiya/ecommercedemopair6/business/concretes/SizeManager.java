package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.SizeService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.size.CreateSizeRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.size.CreateSizeResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.size.GetAllSizesResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.size.GetSizeResponse;
import com.etiya.ecommercedemopair6.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemopair6.core.util.result.SuccessResult;
import com.etiya.ecommercedemopair6.entities.concretes.Size;
import com.etiya.ecommercedemopair6.repository.abstracts.SizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SizeManager implements SizeService {
    private MessageSource messageSource;
   private SizeRepository sizeRepository;
   private ModelMapperService modelMapperService;
    @Override
    public DataResult<GetSizeResponse> getById(int id) {
        Size size =  sizeRepository.findById(id).orElseThrow();
        GetSizeResponse response = modelMapperService.forResponse().map(size, GetSizeResponse.class);
        return new SuccessDataResult<>(response, messageSource.getMessage(Message.Size.getBysizeId,null,
                LocaleContextHolder.getLocale()));
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
        checkIfExistsSizeNumber(createSizeRequest.getNumber());

        Size size = modelMapperService.forRequest().map(createSizeRequest,Size.class);
        Size savedSize = sizeRepository.save(size);
        CreateSizeResponse response = modelMapperService.forResponse().map(savedSize,CreateSizeResponse.class);

       return new SuccessDataResult<>(response, messageSource.getMessage(Message.Size.getBysizeId,null,
               LocaleContextHolder.getLocale()));


    }

    @Override
    public DataResult<Page<Size>> findAll(Pageable pageable) {
        return new SuccessDataResult<>(sizeRepository.findAll(pageable),messageSource.getMessage(Message.Size
                .getAllPageable,null,LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Slice<Size>> findAllSlice(Pageable pageable) {
        return new SuccessDataResult<>(sizeRepository.findAllSlice(pageable),messageSource.getMessage(Message.Size
                .getAllPageable,null,LocaleContextHolder.getLocale()));
    }

    public void checkIfExistsSizeNumber(String name){
        boolean isExists = sizeRepository.existsByNumber(name);
        if (isExists){
            throw new BusinessException(messageSource.getMessage(Message.Size.CheckIfExistsSizeId,null,
                    LocaleContextHolder.getLocale()));

        }
    }
}
