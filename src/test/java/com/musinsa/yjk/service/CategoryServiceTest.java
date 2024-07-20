package com.musinsa.yjk.service;

import com.musinsa.yjk.controller.category.CategoryMinPriceResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;


    @Test
    void getCategoryMinimumPricesTest() {
        CategoryMinPriceResponse categoryMinPriceResponse = categoryService.getCategoryMinimumPrices();

        Assertions.assertNotNull(categoryMinPriceResponse);
        Assertions.assertEquals(categoryMinPriceResponse.getTotalPrice(), "34,100");
    }

}