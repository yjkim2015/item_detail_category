package com.musinsa.yjk.controller.category;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CategoryMinPriceResponse {

    private List<MinPriceItem> 상품목록;
    private String 총액;

    @AllArgsConstructor
    @Getter
    public static class MinPriceItem {
        private String 카테고리;
        private String 브랜드;
        private String 가격;
    }
}
