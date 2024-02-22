package com.ncs.customerservice.Exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
public class CustomErrorInfo {

    private Map<String,String> errorMessage;
    private HttpStatus status;
    private Integer errorCode;

    public CustomErrorInfo(Map<String, String> errorMessage, HttpStatus status, Integer errorCode) {
        this.errorMessage = errorMessage;
        this.status = status;
        this.errorCode = errorCode;
    }
}
