package com.etiya.ecommercedemopair6.business.dto.response.concretes.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCategoryResponse {
    private String categoryName;
    private String description;

}
