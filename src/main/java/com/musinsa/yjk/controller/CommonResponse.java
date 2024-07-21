package com.musinsa.yjk.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
@Data
public class CommonResponse<T> {
    private HttpStatus status;
    private T data;

    public ResponseEntity<CommonResponse> build() {
        return new ResponseEntity<CommonResponse>(this, status);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
