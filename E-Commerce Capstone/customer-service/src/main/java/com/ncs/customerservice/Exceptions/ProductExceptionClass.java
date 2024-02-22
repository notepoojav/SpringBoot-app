package com.ncs.customerservice.Exceptions;

public class ProductExceptionClass extends  RuntimeException{

    public ProductExceptionClass(String message) {
        super(message);
    }

    public ProductExceptionClass(String message, Throwable cause) {
        super(message, cause);
    }
}
