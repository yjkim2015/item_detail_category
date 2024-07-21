package com.musinsa.yjk.service;


import com.musinsa.yjk.controller.category.CategoryBrandMinPriceResponse;
import com.musinsa.yjk.controller.category.CategoryMinMaxResponse;
import com.musinsa.yjk.controller.category.CategoryMinPriceResponse;
import com.musinsa.yjk.dto.CategoryMinMaxDTO;
import com.musinsa.yjk.dto.CategoryMinPriceDTO;
import com.musinsa.yjk.repository.CategoryCustomRepository;
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

    private final CategoryCustomRepository categoryCustomRepository;

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
            totalPrice = totalPrice.add(categoryMinPriceDTO.getPrice());

            CategoryMinPriceResponse.MinPriceItem minPriceItem = new CategoryMinPriceResponse.MinPriceItem(
                    categoryMinPriceDTO.getCategoryName(),
                    categoryMinPriceDTO.getBrandName(),
                    FormatUtils.bigDecimalToString(categoryMinPriceDTO.getPrice()
                    ));
            items.add(minPriceItem);
        }

        return new CategoryMinPriceResponse(
                items,
                FormatUtils.bigDecimalToString(totalPrice)
        );
    }

    public CategoryBrandMinPriceResponse getBrandCategoryMinimumPrices() {
        List<CategoryMinPriceDTO> brandCategoryMinimumPrices = categoryRepository.findBrandCategoryMinimumPrices();

        return convertBrandCategoryMinimumPriceDtoToResponse(brandCategoryMinimumPrices);
    }

    private CategoryBrandMinPriceResponse convertBrandCategoryMinimumPriceDtoToResponse(List<CategoryMinPriceDTO> brandCategoryMinimumPrices) {
        if (CollectionUtils.isEmpty(brandCategoryMinimumPrices)) {
            //TODO throw 처리
        }

        BigDecimal totalPrice = BigDecimal.ZERO;
        List<CategoryBrandMinPriceResponse.CategoryBrandItem> categories = new ArrayList();
        for (CategoryMinPriceDTO categoryMinPriceDTO : brandCategoryMinimumPrices) {
            totalPrice = totalPrice.add(categoryMinPriceDTO.getPrice());

            CategoryBrandMinPriceResponse.CategoryBrandItem categoryBrandItem = new CategoryBrandMinPriceResponse.CategoryBrandItem(
                    categoryMinPriceDTO.getCategoryName(),
                    FormatUtils.bigDecimalToString(categoryMinPriceDTO.getPrice()));

            categories.add(categoryBrandItem);
        }
        return new CategoryBrandMinPriceResponse(
                new CategoryBrandMinPriceResponse.CategoryBrandMinimumPrice(
                        brandCategoryMinimumPrices.get(0).getBrandName(),
                        categories,
                        FormatUtils.bigDecimalToString(totalPrice)
                )
        );
    }

    public CategoryMinMaxResponse getCategoryMinMaxPrice(String categoryName) {
        CategoryMinMaxDTO categoryMinMaxPrice = categoryCustomRepository.findCategoryMinMaxPrice(categoryName);

        return convertCategoryMinMaxDtoToResponse(categoryMinMaxPrice);
    }

    private CategoryMinMaxResponse convertCategoryMinMaxDtoToResponse(CategoryMinMaxDTO categoryMinMaxPrice) {
        if (categoryMinMaxPrice == null) {

        }
        BigDecimal maxPrice = categoryMinMaxPrice.getMaxPrice();
        String maxPriceBrands = categoryMinMaxPrice.getMaxPriceBrands();
        BigDecimal minPrice = categoryMinMaxPrice.getMinPrice();
        String minPriceBrands = categoryMinMaxPrice.getMinPriceBrands();
        String categoryName = categoryMinMaxPrice.getCategoryName();
        List<CategoryMinMaxResponse.CategoryMinMaxItem> 최저가 = new ArrayList<>();
        List<CategoryMinMaxResponse.CategoryMinMaxItem> 최고가 = new ArrayList<>();
        addCategoryMinMaxItems(maxPrice, maxPriceBrands, 최고가);
        addCategoryMinMaxItems(minPrice, minPriceBrands, 최저가);


        return new CategoryMinMaxResponse(
                categoryName,
                최저가,
                최고가
        );
    }

    private void addCategoryMinMaxItems(BigDecimal price, String minMaxBrands, List<CategoryMinMaxResponse.CategoryMinMaxItem> 최저최고가) {
        if (minMaxBrands.contains(",")) {
            String[] brands = minMaxBrands.split(",");
            for (String brand: brands) {
                최저최고가.add(new CategoryMinMaxResponse.CategoryMinMaxItem(
                        brand.trim(), FormatUtils.bigDecimalToString(price)
                ));
            }
        }
        else {
            최저최고가.add(new CategoryMinMaxResponse.CategoryMinMaxItem(
                    minMaxBrands.trim(), FormatUtils.bigDecimalToString(price)
            ));
        }
    }

}
