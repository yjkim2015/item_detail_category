package com.musinsa.yjk.service;


import com.musinsa.yjk.controller.brand.BrandRequest;
import com.musinsa.yjk.entity.Brand;
import com.musinsa.yjk.repository.BrandRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;

    public Long findBrandId(String brandName) throws Exception {
        if (StringUtils.isEmpty(brandName)) throw new Exception("brandName 이 공백입니다");
        Brand brand = brandRepository.findByName(brandName);
        if (brand == null) throw new Exception(String.format("%s에 해당하는 브랜드가 없습니다", brandName));
        return brand.getId();
    }

    public List<Brand> findAllBrand() throws Exception {
       return brandRepository.findAll();
    }

    public Boolean saveBrand(BrandRequest request) throws Exception {
        if (request == null || StringUtils.isEmpty(request.getName())) {
            throw new Exception("%s request 가 null이거나 name이 공백입니다");
        }
        Brand brand = new Brand();
        brand.setName(request.getName());
        brandRepository.save(brand);
        return true;
    }

    public Boolean updateBrand(BrandRequest request) throws Exception {
        Brand brand = brandRepository.findById(request.getId()).orElseThrow(() -> new Exception("id에 해당하는 Brand가 없습니다."));

        brand.setName(request.getName());

        brandRepository.save(brand);
        return true;
    }

    public Boolean deleteBrand(BrandRequest request) {
        brandRepository.deleteById(request.getId());
        return true;
    }
}
