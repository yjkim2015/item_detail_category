package com.musinsa.yjk.controller.product;

import com.musinsa.yjk.controller.CommonResponse;
import com.musinsa.yjk.controller.brand.BrandRequest;
import com.musinsa.yjk.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping(value = "", produces="application/json")
    public ResponseEntity<CommonResponse> findAllProduct() throws Exception {
        CommonResponse result =  new CommonResponse(HttpStatus.OK, productService.findAllProduct());
        return result.build();
    }

    @PostMapping(value = "", produces="application/json")
    public ResponseEntity<CommonResponse> saveProduct(@RequestBody ProductRequest request) throws Exception {
        CommonResponse result =  new CommonResponse(HttpStatus.OK, productService.saveProduct(request));
        return result.build();
    }

    @PutMapping(value = "", produces="application/json")
    public ResponseEntity<CommonResponse> updateBrand(@RequestBody ProductRequest request) {
        CommonResponse result =  new CommonResponse(HttpStatus.OK, productService.updateBrand(request));
        return result.build();
    }

    @DeleteMapping(value = "", produces="application/json")
    public ResponseEntity<CommonResponse> deleteBrand(@RequestBody ProductRequest request) {
        CommonResponse result =  new CommonResponse(HttpStatus.OK, productService.deleteBrand(request));
        return result.build();
    }

}
