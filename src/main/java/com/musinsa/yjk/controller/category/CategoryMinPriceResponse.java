package com.musinsa.yjk.controller.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CategoryMinPriceResponse {

    private List<MinPriceItem> items;
    private String totalPrice;

    @AllArgsConstructor
    @Getter
    public static class MinPriceItem {
        private String categoryName;
        private String brandName;
        private String price;
    }
}
