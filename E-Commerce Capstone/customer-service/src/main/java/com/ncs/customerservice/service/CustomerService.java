package com.ncs.customerservice.service;

import com.ncs.customerservice.dto.CustomerDto;
import com.ncs.customerservice.entity.Customer;
import com.ncs.customerservice.entity.MySessions;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public interface CustomerService {


    Boolean addCustomer(CustomerDto customerDto) throws NoSuchAlgorithmException;

    List<Customer> getAllCustomers();

    Customer getCustomerById(Integer customerId);

    Boolean welcome(CustomerDto customerDto) throws NoSuchAlgorithmException;

    boolean validateUser(MySessions sessions);

    boolean logout(MySessions mySessions);
}
