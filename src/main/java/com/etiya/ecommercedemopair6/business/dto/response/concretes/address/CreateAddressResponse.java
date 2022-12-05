package com.etiya.ecommercedemopair6.business.dto.response.concretes.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressResponse {
    private String title;
    private int streetId;
    private int cityId;
    private int countryId;

    public CreateAddressResponse(String title) {
        this.title = title;
    }
}
