package com.ncs.customerservice.utility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T>{


    private String status;

    private String message;

    T data;
}
