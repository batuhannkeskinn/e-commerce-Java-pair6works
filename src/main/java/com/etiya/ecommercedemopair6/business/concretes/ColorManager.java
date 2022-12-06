package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.ColorService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.Color.CreateColorRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.color.CreateColorResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Color;
import com.etiya.ecommercedemopair6.repository.abstracts.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {

    private ColorRepository colorRepository;
    @Override
    public Color getById(int id) {
        return colorRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Color> getAllColor() {
        return colorRepository.findAll();
    }

    @Override
    public CreateColorResponse createColor(CreateColorRequest createColorRequest) {
        Color color= new Color();
        color.setColorName(createColorRequest.getColorName());
        Color savedColor = colorRepository.save(color);
        CreateColorResponse response = new CreateColorResponse(savedColor.getColorName());
        return response;
    }
}
