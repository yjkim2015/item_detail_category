package com.musinsa.yjk.controller.category;


import com.musinsa.yjk.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/v1/category/min-prices")
    public CategoryMinPriceResponse getCategoryMinimumPrices() {
        return categoryService.getCategoryMinimumPrices();
    }

    @GetMapping("/v1/category/brand/min-prices")
    public CategoryBrandMinPriceResponse getBrandCategoryMinimumPrices() {
        return categoryService.getBrandCategoryMinimumPrices();
    }
}
