package com.ncs.customerservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataWithSession<T> {

    private String customerName;
    private String sessionkey;
    T data;
}
