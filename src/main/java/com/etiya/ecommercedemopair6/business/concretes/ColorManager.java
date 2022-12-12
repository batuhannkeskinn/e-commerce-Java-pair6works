package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.ColorService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.Color.CreateColorRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.color.CreateColorResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.color.GetAllColorResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.color.GetColorResponse;
import com.etiya.ecommercedemopair6.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemopair6.core.util.result.SuccessResult;
import com.etiya.ecommercedemopair6.entities.concretes.Color;
import com.etiya.ecommercedemopair6.repository.abstracts.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {

    private ColorRepository colorRepository;
    private ModelMapperService modelMapperService;
    @Override
    public DataResult<GetColorResponse> getById(int id) {
        Color color = colorRepository.findById(id).orElseThrow();
        GetColorResponse response = modelMapperService
                .forResponse().map(color,GetColorResponse.class);


        return new SuccessDataResult<>(response, Message.Color.getByColorId);
    }

    @Override
    public DataResult< List<GetAllColorResponse>> getAllColor() {
        List<Color> colors = colorRepository.findAll();
        List<GetAllColorResponse> responses = colors.stream()
                .map(color -> modelMapperService.forResponse().map(color,GetAllColorResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(responses,Message.Color.getAllColors);
    }

    @Override
    public Result createColor(CreateColorRequest createColorRequest) {
        //***********************************ManuelMapper******************************************
        checkIfExistsColorName(createColorRequest.getColorName());

//        Color color= new Color();
//        color.setColorName(createColorRequest.getColorName());
//        Color savedColor = colorRepository.save(color);
//        CreateColorResponse response = new CreateColorResponse(savedColor.getColorName());

        Color color = modelMapperService.forRequest().map(createColorRequest,Color.class);
        Color savedColor = colorRepository.save(color);
        CreateColorResponse response = modelMapperService.forResponse().map(savedColor,CreateColorResponse.class);

        return new SuccessResult(Message.Color.createColor);
    }

    public void checkIfExistsColorName(String name){
        boolean isExists = colorRepository.existsByColorName(name);
        if (isExists){
            throw new BusinessException(Message.Color.runTimeException);
        }
    }
}
