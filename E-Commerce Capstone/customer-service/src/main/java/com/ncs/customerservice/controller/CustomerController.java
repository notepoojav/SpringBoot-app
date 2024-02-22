package com.ncs.customerservice.controller;

import com.ncs.customerservice.dto.CustomerDto;
import com.ncs.customerservice.entity.Customer;
import com.ncs.customerservice.entity.MySessions;
import com.ncs.customerservice.repository.CustomerRepository;
import com.ncs.customerservice.utility.LoginData;
import com.ncs.customerservice.utility.Response;
import com.ncs.customerservice.repository.SessionRepository;
import com.ncs.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @PostMapping("/customer/register")
    public ResponseEntity<Response> addCustomer(@Valid @RequestBody CustomerDto customerDto) throws NoSuchAlgorithmException {

        Response sendResponse = new Response();

        if( customerService.addCustomer(customerDto)){
            sendResponse.setStatus("success");
            sendResponse.setMessage("Valid user entered");
        }
        else{
            sendResponse.setStatus("failure");
            sendResponse.setMessage("User already exists");
        }

        return new ResponseEntity<>(sendResponse,HttpStatus.OK);


    }

    @PostMapping("/customer/login")
    public ResponseEntity<Response>  welcome(@RequestBody CustomerDto customerDto) throws NoSuchAlgorithmException {
        Response sendResponse = new Response();
        if( customerService.welcome(customerDto)){

            Customer customer = new Customer();
            customer = customerRepository.findByEmail(customerDto.getEmail());
            System.out.println(customer.getCustomerName());
            sendResponse.setStatus("success");
            sendResponse.setMessage("Valid user entered");

            MySessions mySessions = new MySessions();
            mySessions.setSessionkey(generateRandomString(32));
            mySessions.setCustomerName(customer.getCustomerName());
            sessionRepository.save(mySessions);

            LoginData loginData = new LoginData(customer.getCustomerName(),mySessions.getSessionkey(),customer.getMobile());
            sendResponse.setData(loginData);

        }
        else{
            sendResponse.setStatus("failure");
            sendResponse.setMessage("Invalid credentials");
        }
        return new ResponseEntity<>(sendResponse,HttpStatus.OK);

    }

    @PostMapping("/customer/logout")
    public ResponseEntity<Response> logout(@RequestBody MySessions mySessions){
        System.out.println("INSIDE LOGOUT API");
        System.out.println(mySessions.getCustomerName());
        Response response = new Response();

        if(customerService.logout(mySessions)){

            response.setStatus("success");
            response.setMessage("logout done right");
        }
        else{
            response.setStatus("failure");
            response.setMessage("logout not done right");
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    public String generateRandomString(int length){

        String randomString = "frbiwjfnoekwnfcweuhwr1233298764";
        String createRandomString = "";
        int len = randomString.length()-1;

        for(int i=0;i<length;i++){
            createRandomString += randomString.charAt((int)(Math.random()*len));
        }
        return createRandomString;
    }


}
