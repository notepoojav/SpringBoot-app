package com.ncs.customerservice.Exceptions;
import com.ncs.customerservice.Exceptions.ProductExceptionClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProductExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ProductExceptionClass.class})
    public ResponseEntity<ErrorInfo> handleException( ProductExceptionClass e){
        //1. payload to send exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ErrorInfo info = new ErrorInfo(
                e.getMessage(),
                badRequest,
                400
        );

        return new ResponseEntity<>(info,badRequest);
    }



}







