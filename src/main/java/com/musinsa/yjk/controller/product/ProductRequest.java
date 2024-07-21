package com.musinsa.yjk.controller.product;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    private Long id;
    private Long categoryId;
    private BigDecimal price;
    private Long brandId;
}
