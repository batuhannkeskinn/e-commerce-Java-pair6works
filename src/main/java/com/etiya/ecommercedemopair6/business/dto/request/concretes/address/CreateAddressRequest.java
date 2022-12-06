package com.etiya.ecommercedemopair6.business.dto.request.concretes.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressRequest {

    private String title;
    @Min(value = 0)
    private int addressId;
    @Min(value = 0)
    private int streetId;
    @Min(value = 0)
    private int cityId;
    @Min(value = 0)
    private int countryId;
}
