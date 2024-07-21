package com.musinsa.yjk.service;


import com.musinsa.yjk.controller.brand.BrandRequest;
import com.musinsa.yjk.entity.Brand;
import com.musinsa.yjk.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;


    public Boolean saveBrand(BrandRequest request) {
        Brand brand = new Brand();
        brand.setName(request.getName());
        brandRepository.save(brand);
        return true;
    }

    public Boolean updateBrand(BrandRequest request) {
        Brand brand = brandRepository.findById(Long.parseLong(request.getId())).get();
        brand.setName(request.getName());

        brandRepository.save(brand);
        return true;
    }

    public Boolean deleteBrand(BrandRequest request) {
        brandRepository.deleteById(Long.parseLong(request.getId()));
        return true;
    }
}
