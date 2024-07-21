package com.musinsa.yjk.controller.category;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CategoryBrandMinPriceResponse {
    private CategoryBrandMinimumPrice 최저가;

    @AllArgsConstructor
    @Getter
    public static class CategoryBrandMinimumPrice {
        private String 브랜드;
        private List<CategoryBrandItem> 카테고리;
        private String 총액;
    }

    @AllArgsConstructor
    @Getter
    public static class CategoryBrandItem {
        private String 카테고리;
        private String 가격;
    }
}
