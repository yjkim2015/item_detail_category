package com.musinsa.yjk.service;


import com.musinsa.yjk.controller.category.CategoryMinPriceResponse;
import com.musinsa.yjk.dto.CategoryMinPriceDTO;
import com.musinsa.yjk.repository.CategoryRepository;
import com.musinsa.yjk.utils.FormatUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryMinPriceResponse getCategoryMinimumPrices() {

        List<CategoryMinPriceDTO> categoryMinimumPrices = categoryRepository.findCategoryMinimumPrice();
        return convertCategoryMinPriceToResponse(categoryMinimumPrices);
    }

    private CategoryMinPriceResponse convertCategoryMinPriceToResponse(List<CategoryMinPriceDTO> categoryMinimumPrices) {
        if (CollectionUtils.isEmpty(categoryMinimumPrices)) {
            //TODO throw 처리
        }

        BigDecimal totalPrice = BigDecimal.ZERO;
        List<CategoryMinPriceResponse.MinPriceItem> items = new ArrayList<>();

        for (CategoryMinPriceDTO categoryMinPriceDTO : categoryMinimumPrices) {
            totalPrice = totalPrice.add(categoryMinPriceDTO.getMinPrice());

            CategoryMinPriceResponse.MinPriceItem minPriceItem = new CategoryMinPriceResponse.MinPriceItem(
                    categoryMinPriceDTO.getCategoryName(),
                    categoryMinPriceDTO.getBrandName(),
                    FormatUtils.bigDecimalToString(categoryMinPriceDTO.getMinPrice()
            ));
            items.add(minPriceItem);
        }

        return new CategoryMinPriceResponse(
                items,
                FormatUtils.bigDecimalToString(totalPrice)
        );
    }

}
