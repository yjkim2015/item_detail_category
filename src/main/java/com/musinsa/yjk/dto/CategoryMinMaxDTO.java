package com.musinsa.yjk.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class CategoryMinMaxDTO {
    private String categoryName;
    private BigDecimal minPrice;
    private String minPriceBrands;
    private BigDecimal maxPrice;
    private String maxPriceBrands;
}
