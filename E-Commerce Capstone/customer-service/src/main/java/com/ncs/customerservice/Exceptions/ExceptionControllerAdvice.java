package com.ncs.customerservice.Exceptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {CustomerNotFoundException.class})
    public ResponseEntity<ErrorInfo> handleException( CustomerNotFoundException e){
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







