package com.musinsa.yjk.repository;

import com.musinsa.yjk.dto.CategoryMinMaxDTO;
import com.musinsa.yjk.dto.CategoryMinPriceDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.math.BigDecimal;


@DataJpaTest
@ComponentScan(basePackages = "com.musinsa.yjk")
class CategoryCustomRepositoryTest {

    @Autowired
    private CategoryCustomRepository categoryCustomRepository;

    @Test
    void findCategoryMinMaxPriceTest1() {
        CategoryMinMaxDTO categoryMinMaxDTO = categoryCustomRepository.findCategoryMinMaxPrice("상의");
        // 결과 검증
        Assertions.assertNotNull(categoryMinMaxDTO);

        String categoryName = categoryMinMaxDTO.getCategoryName();
        BigDecimal maxPrice = categoryMinMaxDTO.getMaxPrice();
        BigDecimal minPrice = categoryMinMaxDTO.getMinPrice();
        String maxPriceBrands = categoryMinMaxDTO.getMaxPriceBrands();
        String minPriceBrands = categoryMinMaxDTO.getMinPriceBrands();
        System.out.println("categoryName : " + categoryName);
        System.out.println("maxPrice : " + maxPrice);
        System.out.println("minPrice : " + minPrice);
        System.out.println("maxPriceBrands : " + maxPriceBrands);
        System.out.println("minPriceBrands : " + minPriceBrands);

        Assertions.assertEquals("상의", categoryName);
        Assertions.assertEquals(maxPrice.compareTo(BigDecimal.valueOf(11400)), 0);
        Assertions.assertEquals(minPrice.compareTo(BigDecimal.valueOf(10000)), 0);
        Assertions.assertEquals(maxPriceBrands, "I");
        Assertions.assertEquals(minPriceBrands, "C");

    }

    @Test
    void findCategoryMinMaxPriceTest2() {
        CategoryMinMaxDTO categoryMinMaxDTO = categoryCustomRepository.findCategoryMinMaxPrice("스니커즈");
        // 결과 검증
        Assertions.assertNotNull(categoryMinMaxDTO);

        String categoryName = categoryMinMaxDTO.getCategoryName();
        BigDecimal maxPrice = categoryMinMaxDTO.getMaxPrice();
        BigDecimal minPrice = categoryMinMaxDTO.getMinPrice();
        String maxPriceBrands = categoryMinMaxDTO.getMaxPriceBrands();
        String minPriceBrands = categoryMinMaxDTO.getMinPriceBrands();
        System.out.println("categoryName : " + categoryName);
        System.out.println("maxPrice : " + maxPrice);
        System.out.println("minPrice : " + minPrice);
        System.out.println("maxPriceBrands : " + maxPriceBrands);
        System.out.println("minPriceBrands : " + minPriceBrands);

        Assertions.assertEquals("스니커즈", categoryName);
        Assertions.assertEquals(maxPrice.compareTo(BigDecimal.valueOf(9900)), 0);
        Assertions.assertEquals(minPrice.compareTo(BigDecimal.valueOf(9000)), 0);
        Assertions.assertEquals(maxPriceBrands, "E");
        Assertions.assertEquals(minPriceBrands, "A, G");

    }

}