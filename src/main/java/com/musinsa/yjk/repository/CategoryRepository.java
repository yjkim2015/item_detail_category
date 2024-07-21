package com.musinsa.yjk.repository;

import com.musinsa.yjk.dto.CategoryMinMaxDTO;
import com.musinsa.yjk.dto.CategoryMinPriceDTO;
import com.musinsa.yjk.entity.Product;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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

    /*
        SELECT B.NAME AS BRAND_NAME, C.NAME, P.PRICE
            FROM PRODUCT P
            JOIN BRAND B ON P.BRAND_ID = B.ID
            JOIN CATEGORY C ON P.CATEGORY_ID = C.ID
            WHERE B.ID = (

            SELECT B2.ID
                    FROM PRODUCT P2
                    JOIN BRAND B2 ON P2.BRAND_ID = B2.ID
                    JOIN CATEGORY C2 ON P2.CATEGORY_ID = C2.ID
                    GROUP BY B2.ID
                    HAVING SUM(P2.PRICE)  =
            (
                SELECT MIN(TOTAL_PRICES)
                FROM (
                    SELECT B2.ID, SUM(P2.PRICE) AS TOTAL_PRICES
                    FROM PRODUCT P2
                    JOIN BRAND B2 ON P2.BRAND_ID = B2.ID
                    JOIN CATEGORY C2 ON P2.CATEGORY_ID = C2.ID
                    GROUP BY B2.ID
                ) AS MIN_PRICES
            )

            )
            GROUP BY B.ID, C.ID
     */
    @Query("SELECT new com.musinsa.yjk.dto.CategoryMinPriceDTO(c.name, b.name, p.price) " +
            "FROM Product p " +
            "JOIN p.brand b " +
            "JOIN p.category c " +
            "WHERE b.id = (" +
            "    SELECT b2.id " +
            "    FROM Product p2 " +
            "    JOIN p2.brand b2 " +
            "    JOIN p2.category c2 " +
            "    GROUP BY b2.id " +
            "    HAVING SUM(p2.price) = (" +
            "        SELECT MIN(totalPrices) " +
            "        FROM (" +
            "            SELECT SUM(p3.price) AS totalPrices " +
            "            FROM Product p3 " +
            "            JOIN p3.brand b3 " +
            "            JOIN p3.category c3 " +
            "            GROUP BY b3.id" +
            "        )" +
            "    )" +
            ") " +
            "GROUP BY c.name, b.name")
    List<CategoryMinPriceDTO> findBrandCategoryMinimumPrices();
}
