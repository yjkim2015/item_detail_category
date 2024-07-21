package com.musinsa.yjk.service;

import com.musinsa.yjk.controller.category.CategoryBrandMinPriceResponse;
import com.musinsa.yjk.controller.category.CategoryMinMaxResponse;
import com.musinsa.yjk.controller.category.CategoryMinPriceResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;


    @Test
    void getCategoryMinimumPricesTest() {
        CategoryMinPriceResponse categoryMinPriceResponse = categoryService.getCategoryMinimumPrices();

        Assertions.assertNotNull(categoryMinPriceResponse);
        Assertions.assertEquals(categoryMinPriceResponse.get총액(), "34,100");
    }

    @Test
    void getBrandCategoryMinimumPricesTest() {
        CategoryBrandMinPriceResponse brandCategoryMinimumPrices = categoryService.getBrandCategoryMinimumPrices();
        Assertions.assertNotNull(brandCategoryMinimumPrices);
        CategoryBrandMinPriceResponse.CategoryBrandMinimumPrice minimumPrice = brandCategoryMinimumPrices.get최저가();
        Assertions.assertEquals(minimumPrice.get총액(), "36,100");
        Assertions.assertEquals(minimumPrice.get브랜드(), "D");
    }

    @Test
    void findCategoryMinMaxPriceTest() {
        CategoryMinMaxResponse categoryMinMaxResponse = categoryService.getCategoryMinMaxPrice("상의");
        Assertions.assertNotNull(categoryMinMaxResponse);
        List<CategoryMinMaxResponse.CategoryMinMaxItem> 최고가 = categoryMinMaxResponse.get최고가();
        List<CategoryMinMaxResponse.CategoryMinMaxItem> 최저가 = categoryMinMaxResponse.get최저가();
        String 카테고리 = categoryMinMaxResponse.get카테고리();

        CategoryMinMaxResponse.CategoryMinMaxItem categoryMaxItem = 최고가.get(0);
        CategoryMinMaxResponse.CategoryMinMaxItem categoryMinItem = 최저가.get(0);
        Assertions.assertEquals(카테고리, "상의");
        Assertions.assertEquals("10,000", categoryMinItem.get가격());
        Assertions.assertEquals("C", categoryMinItem.get브랜드());
        Assertions.assertEquals("11,400", categoryMaxItem.get가격());
        Assertions.assertEquals("I", categoryMaxItem.get브랜드());
    }
}