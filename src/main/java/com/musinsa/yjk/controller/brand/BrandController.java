package com.musinsa.yjk.controller.brand;


import com.musinsa.yjk.controller.CommonResponse;
import com.musinsa.yjk.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @PostMapping(value = "/v1/brand", produces="application/json")
    public ResponseEntity<CommonResponse> saveBrand(@RequestBody BrandRequest request) {
        CommonResponse result =  new CommonResponse(HttpStatus.OK, brandService.saveBrand(request));
        return result.build();
    }

    @PutMapping(value = "/v1/brand", produces="application/json")
    public ResponseEntity<CommonResponse> updateBrand(@RequestBody BrandRequest request) {
        CommonResponse result =  new CommonResponse(HttpStatus.OK, brandService.updateBrand(request));
        return result.build();
    }

    @DeleteMapping(value = "/v1/brand", produces="application/json")
    public ResponseEntity<CommonResponse> deleteBrand(@RequestBody BrandRequest request) {
        CommonResponse result =  new CommonResponse(HttpStatus.OK, brandService.deleteBrand(request));
        return result.build();
    }
}
