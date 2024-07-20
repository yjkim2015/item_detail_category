package com.musinsa.yjk.repository;

import com.musinsa.yjk.dto.CategoryMinPriceDTO;
import com.musinsa.yjk.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryRepository extends JpaRepository<Product, Long> {
    // 카테고리별 최소 가격 조회
    @Query("SELECT new com.musinsa.yjk.dto.CategoryMinPriceDTO(c.name, b.name, MIN(p.price)) " +
            "FROM Product p " +
            "JOIN p.category c " +
            "JOIN p.brand b " +
            "WHERE p.id IN (" +
            "    SELECT p2.id " +
            "    FROM Product p2 " +
            "    JOIN p2.category c2 " +
            "    JOIN p2.brand b2 " +
            "    WHERE p2.id = (" +
            "        SELECT p3.id " +
            "        FROM Product p3 " +
            "        WHERE p3.category.id = c2.id " +
            "        ORDER BY p3.price ASC " +
            "        LIMIT 1" +
            "    )" +
            ") " +
            "GROUP BY c.name, b.name ")
    List<CategoryMinPriceDTO> findCategoryMinimumPrice();
}
