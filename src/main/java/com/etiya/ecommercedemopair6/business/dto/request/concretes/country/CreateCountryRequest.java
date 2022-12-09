package com.etiya.ecommercedemopair6.business.dto.request.concretes.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCountryRequest {
    private int countryId;
    private String countryName;

}
