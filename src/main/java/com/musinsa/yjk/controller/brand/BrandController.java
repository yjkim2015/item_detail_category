package com.musinsa.yjk.controller.brand;


import com.musinsa.yjk.controller.CommonResponse;
import com.musinsa.yjk.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/brand")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @GetMapping(value = "", produces="application/json")
    public ResponseEntity<CommonResponse> findBrand(@RequestParam(name = "brandName") String brandName) throws Exception {
        CommonResponse result =  new CommonResponse(HttpStatus.OK, brandService.findBrandId(brandName));
        return result.build();
    }

    @GetMapping(value = "", produces="application/json")
    public ResponseEntity<CommonResponse> findAllBrand() throws Exception {
        CommonResponse result =  new CommonResponse(HttpStatus.OK, brandService.findAllBrand());
        return result.build();
    }

    @PostMapping(value = "", produces="application/json")
    public ResponseEntity<CommonResponse> saveBrand(@RequestBody BrandRequest request) throws Exception {
        CommonResponse result =  new CommonResponse(HttpStatus.OK, brandService.saveBrand(request));
        return result.build();
    }

    @PutMapping(value = "", produces="application/json")
    public ResponseEntity<CommonResponse> updateBrand(@RequestBody BrandRequest request) throws Exception {
        CommonResponse result =  new CommonResponse(HttpStatus.OK, brandService.updateBrand(request));
        return result.build();
    }

    @DeleteMapping(value = "", produces="application/json")
    public ResponseEntity<CommonResponse> deleteBrand(@RequestBody BrandRequest request) {
        CommonResponse result =  new CommonResponse(HttpStatus.OK, brandService.deleteBrand(request));
        return result.build();
    }
}
