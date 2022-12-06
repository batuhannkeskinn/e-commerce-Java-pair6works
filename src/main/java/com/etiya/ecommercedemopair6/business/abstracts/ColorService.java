package com.etiya.ecommercedemopair6.business.abstracts;

import com.etiya.ecommercedemopair6.business.dto.request.concretes.Color.CreateColorRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.color.CreateColorResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Color;

import java.util.List;

public interface ColorService {
    Color getById(int id);
    List<Color> getAllColor();
    CreateColorResponse createColor(CreateColorRequest createColorRequest);
}
