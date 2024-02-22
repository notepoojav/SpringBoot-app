package com.ncs.customerservice.utility;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginData {
    //data passed in whole session

    private String customerName;
    private String key;
    private String mobile;
}
