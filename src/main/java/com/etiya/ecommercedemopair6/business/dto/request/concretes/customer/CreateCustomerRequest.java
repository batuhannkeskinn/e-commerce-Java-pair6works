package com.etiya.ecommercedemopair6.business.dto.request.concretes.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {
    private String phoneNumber;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private Date birthDay;
    @Min(value = 0)
    private int addressId;//join



}
