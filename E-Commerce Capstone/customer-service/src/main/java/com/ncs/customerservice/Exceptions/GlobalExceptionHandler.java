package com.ncs.customerservice.Exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler{

    //@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<CustomErrorInfo> parameterExceptionHandler(MethodArgumentNotValidException e) {
        log.info("Inside parameterExceptionHandler of GlobalExceptionHandler");

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        Map<String,String> errorMap = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach(error->{
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        CustomErrorInfo info = new CustomErrorInfo(
                errorMap,
                badRequest,
                400);

        System.out.println(errorMap);

        return new ResponseEntity<>(info,badRequest);
    }

}
