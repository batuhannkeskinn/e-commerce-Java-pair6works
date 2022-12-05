package com.etiya.ecommercedemopair6.business.dto.request.concretes.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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




}
