package com.etiya.ecommercedemopair6.business.dto.request.concretes.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {



    @NotBlank
    @NotNull
    @Min(value = 1)
    private int orderQuantity;

    @NotNull
    @NotBlank
    private int customerId;

    @NotNull
    @NotBlank
    private int productId;

    @NotNull
    @NotBlank
    private int supplierId;



}
