package com.musinsa.yjk.controller.category;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CategoryMinMaxResponse {
    private String 카테고리;
    private List<CategoryMinMaxItem> 최저가;
    private List<CategoryMinMaxItem> 최고가;

    @AllArgsConstructor
    @Getter
    public static class CategoryMinMaxItem {
        private String 브랜드;
        private String 가격;
    }
}
