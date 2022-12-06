package com.etiya.ecommercedemopair6.business.dto.request.concretes.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressRequest {
    private String title;
    private int addressId;
    private int streetId;
    private int cityId;
    private int countryId;
}
