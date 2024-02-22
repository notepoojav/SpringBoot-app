package com.ncs.customerservice.Exceptions;

import org.springframework.http.HttpStatus;

public class ErrorInfo {

    private String errorMessage;
    private HttpStatus status;
    private Integer errorCode;

    public ErrorInfo(String errorMessage, HttpStatus status, Integer errorCode) {
        this.errorMessage = errorMessage;
        this.status = status;
        this.errorCode = errorCode;
    }



    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
