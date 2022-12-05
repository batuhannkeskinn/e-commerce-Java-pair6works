package com.etiya.ecommercedemopair6.business.dto.response.concretes.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreateCategoryResponse {
    private String categoryName;
    private String description;


}