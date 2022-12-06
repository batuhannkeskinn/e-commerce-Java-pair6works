package com.etiya.ecommercedemopair6.business.dto.request.concretes.category;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryRequest {
    @NotNull
    @NotBlank
    private String categoryName;
    private String description;
}
