package com.musinsa.yjk.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;


@Getter
@AllArgsConstructor
public class CategoryMinPriceDTO {
    private String categoryName;
    private String brandName;
    private BigDecimal price;
}
