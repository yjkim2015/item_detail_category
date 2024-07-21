package com.musinsa.yjk.service;


import com.musinsa.yjk.controller.brand.BrandRequest;
import com.musinsa.yjk.controller.product.ProductRequest;
import com.musinsa.yjk.entity.Brand;
import com.musinsa.yjk.entity.Category;
import com.musinsa.yjk.entity.Product;
import com.musinsa.yjk.repository.BrandRepository;
import com.musinsa.yjk.repository.CategoryRepository;
import com.musinsa.yjk.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public Boolean saveProduct(ProductRequest request) throws Exception {
        Long brandId = request.getBrandId();
        Long categoryId = request.getCategoryId();
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new Exception("id에 해당하는 Category 가 없습니다."));
        Brand brand = brandRepository.findById(brandId).orElseThrow(() -> new Exception("id에 해당하는 Brand가 없습니다."));;

        Product product = new Product();
        product.setCategory(category);
        product.setPrice(request.getPrice());
        product.setBrand(brand);
        productRepository.save(product);
        return true;
    }

    @SneakyThrows
    public Boolean updateBrand(ProductRequest request) {
        Product product = productRepository.findById(request.getId()).orElseThrow(() -> new Exception("id에 해당하는 Product 가 없습니다."));

        Brand brand = product.getBrand();
        Category category = product.getCategory();

        product.setPrice(request.getPrice());
        brand.setId(request.getBrandId());
        category.setId(request.getCategoryId());

        productRepository.save(product);
        return true;
    }

    public Boolean deleteBrand(ProductRequest request) {
        productRepository.deleteById(request.getId());
        return true;
    }
}
