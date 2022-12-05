package com.etiya.ecommercedemopair6.business.dto.request.concretes.category;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryRequest {
    private String categoryName;
    private String description;
}
