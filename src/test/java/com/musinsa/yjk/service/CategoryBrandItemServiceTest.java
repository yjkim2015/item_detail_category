package com.musinsa.yjk.service;

import com.musinsa.yjk.controller.category.CategoryBrandMinPriceResponse;
import com.musinsa.yjk.controller.category.CategoryMinPriceResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CategoryBrandItemServiceTest {

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

}