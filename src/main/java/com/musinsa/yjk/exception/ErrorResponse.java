package com.musinsa.yjk.exception;


import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
public class ErrorResponse extends RuntimeException {
    private Instant timestamp;
    private final HttpStatus httpStatus;
    private final String message;
    private String path;
    private final Object data;
    public ErrorResponse(HttpStatus httpStatus, String message, Object data) {
        	this.httpStatus = httpStatus;
            this.message = message;
            this.data = data;

    }
    public ErrorResponse(ErrorCode errorCode) {
        this.httpStatus = errorCode.getStatus();
        this.message = errorCode.getMessage();
        this.data = null;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public int getStatus() {
        return httpStatus.value();
    }
}
