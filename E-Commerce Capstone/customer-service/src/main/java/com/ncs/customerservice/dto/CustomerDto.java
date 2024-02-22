package com.ncs.customerservice.dto;

import com.ncs.customerservice.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.*;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto implements Serializable {
    private Integer customerId;
    @NotBlank(message = "Username is required!")
    @Size(min = 1, max = 225, message="Username is too long")
    private String customerName;
    @Email(message = "Email ID is not Valid")
    private String email;

    @NotNull(message = "This field can't be empty")
    private String mobile;

    @NotNull(message = "This field can't be empty")
    @Size(min = 8, max = 30, message = "Should be minimum 8 characters")
    private String password;

    public CustomerDto(Customer customer){

        ModelMapper modelMapper = new ModelMapper();
        CustomerDto customerDto = modelMapper.map(customer,CustomerDto.class);
        this.customerId = customerDto.getCustomerId();
        this.customerName = customerDto.getCustomerName();
        this.email = customerDto.getEmail();
        this.password = customerDto.getPassword();
        this.mobile = customerDto.getMobile();


    }
}
