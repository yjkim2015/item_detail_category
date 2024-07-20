package com.musinsa.yjk.repository;

import com.musinsa.yjk.dto.CategoryMinPriceDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testFindCategoryMinimumPriceBrandAndTotalSum() {

        // 카테고리 별 최저가격 브랜드와 총액 조회
        List<CategoryMinPriceDTO> results = categoryRepository.findCategoryMinimumPrice();

        // 결과 검증
        Assertions.assertNotNull(results);
        Assertions.assertFalse(results.isEmpty());

        BigDecimal totalSum = BigDecimal.ZERO;
        for (CategoryMinPriceDTO dto : results) {
            System.out.println("카테고리 이름 리스트: " + dto.getCategoryName());
            System.out.println("브랜드 이름 리스트: " + dto.getBrandName());
            System.out.println("최소 상품 가격 리스트: " + dto.getMinPrice());
            totalSum = totalSum.add(dto.getMinPrice());

            Assertions.assertNotNull(dto.getCategoryName());
            Assertions.assertNotNull(dto.getBrandName());
            Assertions.assertNotNull(dto.getMinPrice());
        }
        System.out.println("totalSum : " + totalSum);
        Assertions.assertEquals(totalSum.compareTo(BigDecimal.valueOf(34100)), 0);
    }
}