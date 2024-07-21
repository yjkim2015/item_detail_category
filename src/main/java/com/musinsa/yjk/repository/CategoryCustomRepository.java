package com.musinsa.yjk.repository;

import com.musinsa.yjk.dto.CategoryMinMaxDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class CategoryCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public CategoryMinMaxDTO findCategoryMinMaxPrice(String categoryName) {
        String nativeQuery = "SELECT " +
                "       c.name AS categoryName, " +
                "       MIN(p.price) AS minPrice, " +
                "       STRING_AGG(DISTINCT b_min.name, ', ' ORDER BY p.price ASC) AS minPriceBrands, " +
                "       MAX(p.price) AS maxPrice, " +
                "       STRING_AGG(DISTINCT b_max.name, ', ' ORDER BY p.price DESC) AS maxPriceBrands " +
                "FROM " +
                "       category c " +
                "JOIN " +
                "       product p ON p.category_id = c.id " +
                "LEFT JOIN ( " +
                "       SELECT " +
                "              p1.category_id, " +
                "              p1.price, " +
                "              b.name " +
                "       FROM " +
                "              product p1 " +
                "       JOIN " +
                "              brand b ON p1.brand_id = b.id " +
                "       WHERE " +
                "              p1.price = ( " +
                "                     SELECT " +
                "                            MIN(p2.price) " +
                "                     FROM " +
                "                            product p2 " +
                "                     WHERE " +
                "                            p2.category_id = p1.category_id " +
                "              ) " +
                ") AS b_min ON c.id = b_min.category_id " +
                "LEFT JOIN ( " +
                "       SELECT " +
                "              p3.category_id, " +
                "              p3.price, " +
                "              b.name " +
                "       FROM " +
                "              product p3 " +
                "       JOIN " +
                "              brand b ON p3.brand_id = b.id " +
                "       WHERE " +
                "              p3.price = ( " +
                "                     SELECT " +
                "                            MAX(p4.price) " +
                "                     FROM " +
                "                            product p4 " +
                "                     WHERE " +
                "                            p4.category_id = p3.category_id " +
                "              ) " +
                ") AS b_max ON c.id = b_max.category_id " +
                "WHERE " +
                "       c.name = :categoryName " +
                "GROUP BY " +
                "       c.name";

        Query query = entityManager.createNativeQuery(nativeQuery);
        query.setParameter("categoryName", categoryName);

        Object[] result = (Object[]) query.getSingleResult();

        CategoryMinMaxDTO categoryMinMaxDTO = new CategoryMinMaxDTO();
        categoryMinMaxDTO.setCategoryName((String) result[0]);
        categoryMinMaxDTO.setMinPrice((BigDecimal) result[1]);
        categoryMinMaxDTO.setMinPriceBrands((String) result[2]);
        categoryMinMaxDTO.setMaxPrice((BigDecimal) result[3]);
        categoryMinMaxDTO.setMaxPriceBrands((String) result[4]);

        return categoryMinMaxDTO;
    }
}
